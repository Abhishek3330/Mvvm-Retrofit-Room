package test.com.mvvmretrofitroom.quoteapplication

import android.app.Application
import test.com.mvvmretrofitroom.api.QuotesService
import test.com.mvvmretrofitroom.api.RetrofitHelper
import test.com.mvvmretrofitroom.database.Quotesdatabase
import test.com.mvvmretrofitroom.repository.QuoteRepository

/**
 * Created by Mukesh on 19-01-2023.
 */
class QuoteApplication : Application() {

    lateinit var quoteRepository: QuoteRepository
    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

        val database = Quotesdatabase.getDatabase(applicationContext)
        val quoteService = RetrofitHelper.getInstance().create(QuotesService::class.java)
        quoteRepository = QuoteRepository(quoteService, database,applicationContext)
    }
}