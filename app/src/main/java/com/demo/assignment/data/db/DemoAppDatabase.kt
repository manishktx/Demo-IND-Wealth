package com.demo.assignment.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.demo.assignment.core.Constants
import com.demo.assignment.data.model.list.ReposListingItem

@Database(entities = [ReposListingItem::class],
        version = 1, exportSchema = false)
@TypeConverters(AppConverters::class)
abstract class DemoAppDatabase : RoomDatabase() {

    abstract fun reposDao(): ReposDao


    companion object {

        @Volatile
        private var instance: DemoAppDatabase? = null

        fun getInstance(context: Context): DemoAppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): DemoAppDatabase {
            return Room.databaseBuilder(context, DemoAppDatabase::class.java, Constants.DB.NAME)
                    .addCallback(object : RoomDatabase.Callback() {
                    })
                    .build()
        }
    }
}
