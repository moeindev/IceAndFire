package ir.moeindeveloper.iceandfire.data.pojo.characters


import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("aliases")
    val aliases: List<String>,
    @SerializedName("allegiances")
    val allegiances: List<Any>,
    @SerializedName("books")
    val books: List<String>,
    @SerializedName("born")
    val born: String,
    @SerializedName("culture")
    val culture: String,
    @SerializedName("died")
    val died: String,
    @SerializedName("father")
    val father: String,
    @SerializedName("mother")
    val mother: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("playedBy")
    val playedBy: List<String>,
    @SerializedName("povBooks")
    val povBooks: List<String>,
    @SerializedName("spouse")
    val spouse: String,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("tvSeries")
    val tvSeries: List<String>,
    @SerializedName("url")
    val url: String
)