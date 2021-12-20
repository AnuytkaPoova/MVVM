package com.a_ches.core.viewmodel




interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}