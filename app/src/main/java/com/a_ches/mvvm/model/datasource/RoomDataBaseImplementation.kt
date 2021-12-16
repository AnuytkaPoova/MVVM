package com.a_ches.mvvm.model.datasource

import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.room.HistoryDao
import com.a_ches.mvvm.utils.convertDataModelSuccessToEntity
import com.a_ches.mvvm.utils.mapHistoryEntityToSearchResult


class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}