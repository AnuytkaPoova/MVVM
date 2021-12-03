package com.a_ches.mvvm.model.datasource

import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.datasource.DataSource
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented") // To change body of created functions use File
// | Settings | File Templates.
    }
}