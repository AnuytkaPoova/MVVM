package com.a_ches.mvvm.model.repository

import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.datasource.DataSource


class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}