package com.a_ches.repository

import com.a_ches.model.data.dto.SearchResultDto
import com.a_ches.model.data.userdata.DataModel



class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}
