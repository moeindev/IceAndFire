package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.quote.Quote
import retrofit2.Response
import javax.inject.Inject

class QuotesApiImpl @Inject constructor(private val service: QuotesApiService): QuotesApiHelper {

    override suspend fun getQuotes(): Response<Quote> = service.getQuotes()

    override suspend fun filterQuotes(character: String): Response<Quote> = service.filterQuotes(character)

}