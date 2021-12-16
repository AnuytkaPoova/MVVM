package com.a_ches.mvvm.model.datasource


interface DataSource<T> {

    suspend fun getData(word: String): T


}