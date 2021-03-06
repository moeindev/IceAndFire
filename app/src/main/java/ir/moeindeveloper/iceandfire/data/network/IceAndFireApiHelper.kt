package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import retrofit2.Response

interface IceAndFireApiHelper {


    suspend fun getBooks(page: Int? = null): Response<List<Book>>

    suspend fun getBook(
        bookID: Int
    ): Response<Book>



    suspend fun getCharacters(page: Int? = null): Response<List<Character>>


    suspend fun filterCharacters(
        name: String?,
        gender: String?,
        culture: String?,
        isAlive: Boolean?
    ): Response<List<Character>>

    suspend fun getCharacter(characterID: Int): Response<Character>

    suspend fun getHouses(page: Int? = null): Response<List<House>>

    suspend fun getHouse(houseID: Int): Response<House>
}