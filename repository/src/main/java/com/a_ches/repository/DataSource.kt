package com.a_ches.repository


interface DataSource<T> {

    suspend fun getData(word: String): T
}
