package com.demo.assignment.data.db

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.demo.assignment.core.Constants
import com.demo.assignment.data.model.list.ReposListingItem

@Dao
interface ReposDao {



    @Query("SELECT * FROM ${Constants.DB.Table.Repo.NAME}")
    fun getRepos(): List<ReposListingItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<ReposListingItem>?)

    @Query("DELETE FROM ${Constants.DB.Table.Repo.NAME}")
    suspend fun clear()
    {
    }

}