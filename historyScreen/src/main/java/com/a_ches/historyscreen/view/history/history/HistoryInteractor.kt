package com.a_ches.mvvm.view.history

import com.a_ches.core.viewmodel.Interactor
import com.a_ches.historyscreen.mapSearchResultToResult
import com.a_ches.model.data.AppState
import com.a_ches.model.data.dto.SearchResultDto
import com.a_ches.repository.Repository
import com.a_ches.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}

