package com.demo.assignment.data.source

import com.demo.assignment.data.api.RestAPIService
import javax.inject.Inject

open class ReposRemoteDataSource @Inject constructor(
    private val apiService : RestAPIService
): BaseDataSource() {

    suspend fun getRepos(queryMap: HashMap<String, Any>) =
        getResult { apiService.getRepos(queryMap) }

}