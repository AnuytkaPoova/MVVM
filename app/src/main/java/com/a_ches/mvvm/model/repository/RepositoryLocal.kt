package com.a_ches.mvvm.model.repository

import com.a_ches.mvvm.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}