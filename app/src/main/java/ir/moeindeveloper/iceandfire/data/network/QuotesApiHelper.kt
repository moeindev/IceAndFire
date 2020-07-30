package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.quote.Quote
import retrofit2.Response

interface QuotesApiHelper {

    suspend fun getQuotes(): Response<Quote>

    suspend fun filterQuotes(
        character: String
    ): Response<Quote>
}