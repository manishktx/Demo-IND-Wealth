package com.demo.assignment.data.api

import com.demo.assignment.data.model.list.ResponseReposListing
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RestAPIService {

    @GET("orgs/octokit/repos")
    suspend fun getRepos(
        @QueryMap query: HashMap<String, Any>): Response<ResponseReposListing>

}