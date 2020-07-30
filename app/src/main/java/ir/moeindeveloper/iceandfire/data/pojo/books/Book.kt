package ir.moeindeveloper.iceandfire.data.pojo.books


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("country")
    val country: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("mediaType")
    val mediaType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("numberOfPages")
    val numberOfPages: Int,
    @SerializedName("povCharacters")
    val povCharacters: List<String>,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("released")
    val released: String,
    @SerializedName("url")
    val url: String
)