package com.a_ches.repository

import com.a_ches.model.data.AppState
import com.a_ches.model.data.dto.SearchResultDto
import com.a_ches.model.data.userdata.DataModel
import com.a_ches.mvvm.room.HistoryDao



class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
