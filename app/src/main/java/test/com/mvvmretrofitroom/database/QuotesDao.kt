package test.com.mvvmretrofitroom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import test.com.mvvmretrofitroom.models.QuoteList
import test.com.mvvmretrofitroom.models.QuoteListItem

/**
 * Created by Mukesh on 19-01-2023.
 */

@Dao
interface QuotesDao {

    @Insert
   suspend fun addQuotes(quotes: List<QuoteListItem>?)



    @Query("SELECT * from quotes")
    fun getQuotes(): List<QuoteListItem>
}