package com.a_ches.mvvm.view.main

import com.a_ches.core.viewmodel.Interactor
import com.a_ches.model.data.AppState
import com.a_ches.model.data.DataModel

import com.a_ches.repository.Repository
import com.a_ches.repository.RepositoryLocal


class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}
