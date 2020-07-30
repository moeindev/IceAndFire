package ir.moeindeveloper.iceandfire.data.network

import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import retrofit2.Response
import javax.inject.Inject

class IceAndFireApiImpl @Inject constructor(private val service: IceAndFireApiService) : IceAndFireApiHelper {

    override suspend fun getBooks(): Response<List<Book>> = service.getBooks()

    override suspend fun getBook(bookID: Int): Response<Book> = service.getBook(bookID)

    override suspend fun getCharacters(): Response<List<Character>> = service.getCharacters()

    override suspend fun filterCharacters(
        name: String?,
        gender: String?,
        culture: String?,
        isAlive: Boolean?
    ): Response<List<Character>> = service.filterCharacters(name,gender,culture,isAlive)

    override suspend fun getCharacter(characterID: Int): Response<Character> = service.getCharacter(characterID)

    override suspend fun getHouses(): Response<List<House>> = service.getHouses()

    override suspend fun getHouse(houseID: Int): Response<House> = service.getHouse(houseID)

}