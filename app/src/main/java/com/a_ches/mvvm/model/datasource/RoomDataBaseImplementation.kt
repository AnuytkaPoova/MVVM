package com.a_ches.mvvm.model.datasource

import com.a_ches.mvvm.model.data.DataModel


class RoomDataBaseImplementation : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}