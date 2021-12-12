package com.a_ches.mvvm.model.datasource

import io.reactivex.Observable


interface DataSource<T> {

    //// Источник данных для репозитория (Интернет, БД и т. п.)
    fun getData(word: String): Observable<T>


}