package ir.moeindeveloper.iceandfire.utils.intractors

import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House

interface CharacterClickListener {
    fun onCharacterSelect(character: Character)
}


interface BookClickListener {
    fun onBookSelect(book: Book)
}


interface HouseClickListener {
    fun onHouseSelect(house: House)
}