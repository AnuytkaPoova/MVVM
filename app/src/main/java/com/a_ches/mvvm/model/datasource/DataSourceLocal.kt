package com.a_ches.mvvm.model.datasource

import com.a_ches.mvvm.model.data.DataModel
import io.reactivex.Observable

class DataSourceLocal (private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}