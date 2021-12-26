package com.a_ches.repository

import com.a_ches.model.data.AppState
import com.a_ches.model.data.dto.SearchResultDto
import com.a_ches.model.data.userdata.DataModel

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResultDto>>) :
    RepositoryLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
