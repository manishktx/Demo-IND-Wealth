package com.demo.assignment.di

import android.app.Application
import com.demo.assignment.BuildConfig
import com.demo.assignment.core.Constants
import com.demo.assignment.data.api.RestAPIService
import com.demo.assignment.data.db.DemoAppDatabase
import com.demo.assignment.data.source.ReposRemoteDataSource
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {


    @Singleton
    @Provides
    fun provideAPIService(okHttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory
    ) = provideService(okHttpClient, converterFactory, RestAPIService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: RestAPIService)
            = ReposRemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideDb(app: Application) = DemoAppDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideNewsDao(db: DemoAppDatabase) = db.reposDao()


    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor)
            .build()

    @Provides
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    private fun createRetrofit(
        okHttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.API.ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .build()
    }

    private fun <T> provideService(okHttpClient: OkHttpClient,
            converterFactory: GsonConverterFactory, clazz: Class<T>): T {
        return createRetrofit(okHttpClient, converterFactory).create(clazz)
    }
}
