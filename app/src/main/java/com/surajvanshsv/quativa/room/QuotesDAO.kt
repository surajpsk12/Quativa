package com.surajvanshsv.quativa.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.surajvanshsv.quativa.model.Quote
import kotlinx.coroutines.flow.Flow

@Dao
interface QuotesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuote(quote: Quote)

    @Query("select * from quotes_table")
    fun getQuotes(): Flow<List<Quote>>

    @Delete
    suspend fun deleteQuoteItem(quote : Quote)


}