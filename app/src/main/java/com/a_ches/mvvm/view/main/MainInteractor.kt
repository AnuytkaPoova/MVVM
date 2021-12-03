package com.a_ches.mvvm.view.main

import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.repository.Repository
import com.a_ches.mvvm.viewmodel.Interactor
import io.reactivex.Observable

class MainInteractor (
    // Снабжаем интерактор репозиторием для получения локальных или внешних
    // данных
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
    ) : Interactor<AppState> {
    // Интерактор лишь запрашивает у репозитория данные, детали имплементации
    // интерактору неизвестны
    override fun getData(word: String, fromRemoteSource: Boolean):
            Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}
