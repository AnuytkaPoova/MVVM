package com.a_ches.mvvm.model.repository

import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.datasource.DataSourceLocal

class RepositoryImplementationLocal (private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}