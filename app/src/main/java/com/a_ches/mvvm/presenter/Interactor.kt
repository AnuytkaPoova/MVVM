package com.a_ches.mvvm.presenter

import io.reactivex.Observable


interface Interactor<T> {

    // Use Сase: получение данных для вывода на экран
    // Используем RxJava
    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}