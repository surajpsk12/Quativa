package com.surajvanshsv.quativa.di

import com.surajvanshsv.quativa.retrofit.ApiInterface
import com.surajvanshsv.quativa.retrofit.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // provide Retrofit Instance
    @Singleton
    @Provides
    fun provideRetrofitInstance(): RetrofitInstance {
        return RetrofitInstance()
    }

    // provides apiInterface
    @Provides
    @Singleton
    fun provideApiInterface(retrofitInstance: RetrofitInstance) : ApiInterface {
        return retrofitInstance.apiInterface

    }



}