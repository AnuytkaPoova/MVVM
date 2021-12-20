package com.a_ches.mvvm.view.history

import com.a_ches.core.viewmodel.Interactor
import com.a_ches.model.data.AppState
import com.a_ches.model.data.DataModel

import com.a_ches.repository.Repository
import com.a_ches.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
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
