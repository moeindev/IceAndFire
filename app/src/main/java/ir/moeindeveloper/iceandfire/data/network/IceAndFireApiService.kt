package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IceAndFireApiService {

    @GET("api/books")
    suspend fun getBooks(@Query("page") page: Int? = null): Response<List<Book>>


    @GET("api/books/{id}")
    suspend fun getBook(
        @Path("id") bookID: Int
    ): Response<Book>


    @GET("api/characters")
    suspend fun getCharacters(@Query("page") page: Int? = null): Response<List<Character>>

    @GET("api/characters")
    suspend fun filterCharacters(
        @Query("name") name: String?,
        @Query("gender") gender: String?,
        @Query("culture") culture: String?,
        @Query("isAlive") isAlive: Boolean?
    ): Response<List<Character>>

    @GET("api/characters/{id}")
    suspend fun getCharacter(@Path("id") characterID: Int): Response<Character>


    @GET("api/houses")
    suspend fun getHouses(@Query("page") page: Int? = null): Response<List<House>>

    @GET("api/houses/{id}")
    suspend fun getHouse(@Path("id") houseID: Int): Response<House>


}