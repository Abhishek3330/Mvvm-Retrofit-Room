package test.com.mvvmretrofitroom.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import test.com.mvvmretrofitroom.api.QuotesService
import test.com.mvvmretrofitroom.database.Quotesdatabase
import test.com.mvvmretrofitroom.models.QuoteList
import test.com.mvvmretrofitroom.models.QuoteListItem
import test.com.mvvmretrofitroom.utils.NetworkUtils


/**
 * Created by Mukesh on 17-01-2023.
 */
class QuoteRepository(
    private val quoteService: QuotesService,
    private val quoteDatabase: Quotesdatabase,
    private val applicationContext: Context
) {


    private val quotesLiveData = MutableLiveData<List<QuoteListItem>>()

    val Quotes: LiveData<List<QuoteListItem>>
        get() = quotesLiveData

    suspend fun getQuotes() {

        if (NetworkUtils.isInternetAvailable(applicationContext)) {

            val result = quoteService.getQuotes()
            if (result.body() != null) {
                quoteDatabase.getQuotesDao().addQuotes(result.body())
                quotesLiveData.postValue(result.body())
            }
        } else {
            val quotesLocal = quoteDatabase.getQuotesDao().getQuotes()

            quotesLiveData.postValue(quotesLocal)
        }


    }


}