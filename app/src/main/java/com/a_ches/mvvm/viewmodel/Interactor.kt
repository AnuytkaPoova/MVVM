package com.a_ches.mvvm.viewmodel




interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}