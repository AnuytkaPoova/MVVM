package com.a_ches.mvvm.model.repository

import io.reactivex.Observable


interface Repository<T> {

    // Репозиторий представляет собой слой получения и хранения данных, которые он
   // передаёт интерактору


    fun getData(word: String): Observable<T>

}