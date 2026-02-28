package com.surajvanshsv.quativa.di

import android.content.Context
import com.surajvanshsv.quativa.repository.QuoteRepository
import com.surajvanshsv.quativa.retrofit.ApiInterface
import com.surajvanshsv.quativa.retrofit.RetrofitInstance
import com.surajvanshsv.quativa.room.AppDatabase
import com.surajvanshsv.quativa.room.QuotesDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context) : AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun provideQuotesDAO(appDatabase: AppDatabase): QuotesDAO {
        return appDatabase.quoteDao()

    }





}
