package com.a_ches.mvvm.view.main

import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.repository.Repository
import com.a_ches.mvvm.viewmodel.Interactor


class MainInteractor (
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
