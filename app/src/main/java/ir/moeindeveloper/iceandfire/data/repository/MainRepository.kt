package ir.moeindeveloper.iceandfire.data.repository

import ir.moeindeveloper.iceandfire.data.network.IceAndFireApiHelper
import ir.moeindeveloper.iceandfire.data.network.QuotesApiHelper
import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import ir.moeindeveloper.iceandfire.data.pojo.quote.Quote
import ir.moeindeveloper.iceandfire.di.annotation.IceAndFire
import ir.moeindeveloper.iceandfire.di.annotation.Quotes
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val iceAndFireApiHelper: IceAndFireApiHelper,
                                         private val quotesApiHelper: QuotesApiHelper) {
    suspend fun getBooks(page: Int? = null): Response<List<Book>> = iceAndFireApiHelper.getBooks(page)

    suspend fun getBook(bookID: Int): Response<Book> = iceAndFireApiHelper.getBook(bookID)

    suspend fun getCharacters(page: Int? = null): Response<List<Character>> = iceAndFireApiHelper.getCharacters(page)

    suspend fun filterCharacters(
        name: String?,
        gender: String?,
        culture: String?,
        isAlive: Boolean?
    ): Response<List<Character>> = iceAndFireApiHelper.filterCharacters(name,gender,culture,isAlive)

    suspend fun getCharacter(characterID: Int): Response<Character> = iceAndFireApiHelper.getCharacter(characterID)

    suspend fun getHouses(page: Int? = null): Response<List<House>> = iceAndFireApiHelper.getHouses(page)

    suspend fun getHouse(houseID: Int): Response<House> = iceAndFireApiHelper.getHouse(houseID)


    suspend fun getQuotes(): Response<Quote> = quotesApiHelper.getQuotes()

    suspend fun filterQuotes(character: String): Response<Quote> = quotesApiHelper.filterQuotes(character)
}