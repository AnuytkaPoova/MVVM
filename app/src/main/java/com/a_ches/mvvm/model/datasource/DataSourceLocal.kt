package com.a_ches.mvvm.model.datasource

import com.a_ches.mvvm.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}