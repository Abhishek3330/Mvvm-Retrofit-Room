package test.com.mvvmretrofitroom.api

import retrofit2.Response
import retrofit2.http.GET
import test.com.mvvmretrofitroom.models.QuoteListItem


interface QuotesService {

    @GET("api/quotes")
    suspend fun getQuotes():Response<List<QuoteListItem>>
}