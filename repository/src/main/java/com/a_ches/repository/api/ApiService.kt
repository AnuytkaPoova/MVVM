package com.a_ches.repository.api

import com.a_ches.model.data.dto.SearchResultDto
import com.a_ches.model.data.userdata.DataModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<SearchResultDto>>
}
