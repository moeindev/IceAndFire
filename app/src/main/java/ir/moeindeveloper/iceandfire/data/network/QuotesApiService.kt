package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.quote.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApiService {

    @GET("quotes")
    suspend fun getQuotes(): Response<Quote>

    @GET("quotes")
    suspend fun filterQuotes(
        @Query("char") character: String
    ): Response<Quote>
}