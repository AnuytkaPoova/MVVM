package com.a_ches.repository



interface Repository<T> {

    suspend fun getData(word: String): T
}
