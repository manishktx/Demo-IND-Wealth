package com.demo.assignment.data.source

import com.demo.assignment.data.APIResponse
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.data.model.list.ResponseReposListing
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import com.demo.assignment.data.Result
import com.demo.assignment.data.APIResponse.Success
import com.demo.assignment.data.APIResponse.Failure

suspend fun getRepos(
    databaseQuery: () -> List<ReposListingItem>,
    networkCall: suspend () -> APIResponse<ResponseReposListing>,
    saveCallResult: suspend (ResponseReposListing) -> Unit
) =
    flow {

        emit(Result.Loading)

        when (val responseStatus = networkCall.invoke()) {
            is Success -> {

                responseStatus.data?.takeIf { it.isNotEmpty() }?.let {

                    emit(Result.Success(it))
                    saveCallResult(it)

                } ?: run {
                    emit(Result.Error("Last Page."))

                }
            }
            is Failure -> {

                emit(Result.Error( responseStatus.errorMessage ?: "Error!"))

                val source = databaseQuery.invoke()
                emit(Result.Success(source))
            }
        }

    }.flowOn(Dispatchers.IO)


