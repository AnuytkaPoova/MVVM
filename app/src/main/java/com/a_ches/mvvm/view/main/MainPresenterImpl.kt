package com.a_ches.mvvm.view.main

import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.model.datasource.DataSourceLocal
import com.a_ches.mvvm.model.datasource.DataSourceRemote
import com.a_ches.mvvm.model.repository.RepositoryImplementation
import com.a_ches.mvvm.presenter.Presenter
import com.a_ches.mvvm.rx.SchedulerProvider
import com.a_ches.mvvm.view.base.View
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class MainPresenterImpl <T : AppState, V : View>(
    // Обратите внимание, что Интерактор мы создаём сразу в конструкторе
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    // Мы можем обойтись и без SchedulerProvider, но он вам пригодится для
    //тестирования приложения -- мы будем рассматривать его на следующем курсе более подробно

    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
    ) : Presenter<T, V> {
    // Ссылка на View, никакого контекста
    private var currentView: V? = null

    // Как только появилась View, сохраняем ссылку на неё для дальнейшей работы
    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    // View скоро будет уничтожена: прерываем все загрузки и обнуляем ссылку,
    // чтобы предотвратить утечки памяти и NPE
    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    // Стандартный код RxJava
    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
    // Как только начинается загрузка, передаём во View модель данных для
    // отображения экрана загрузки
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(appState: AppState) {
    // Если загрузка окончилась успешно, передаем модель с данными
    // для отображения
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
    // Если произошла ошибка, передаем модель с ошибкой
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}

