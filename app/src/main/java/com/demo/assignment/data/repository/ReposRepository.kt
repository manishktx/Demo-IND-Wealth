package com.demo.assignment.data.repository

import com.demo.assignment.data.db.ReposDao
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.data.source.ReposRemoteDataSource
import com.demo.assignment.data.source.getRepos
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton
import com.demo.assignment.data.Result
@Singleton
class ReposRepository @Inject constructor(private val dao: ReposDao,
                                          private val remoteSource: ReposRemoteDataSource
) {

    suspend fun loadRepos(queryMap: HashMap<String, Any>):
            Flow<Result<List<ReposListingItem>>> {

        return getRepos(
            databaseQuery = { dao.getRepos() },
            networkCall = { remoteSource.getRepos(queryMap) },
            saveCallResult = { dao.insertAll(it) },
        )
    }

}