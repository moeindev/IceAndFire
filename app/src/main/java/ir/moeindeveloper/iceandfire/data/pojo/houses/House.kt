package ir.moeindeveloper.iceandfire.data.pojo.houses


import com.google.gson.annotations.SerializedName

data class House(
    @SerializedName("ancestralWeapons")
    val ancestralWeapons: List<String>,
    @SerializedName("cadetBranches")
    val cadetBranches: List<String>,
    @SerializedName("coatOfArms")
    val coatOfArms: String,
    @SerializedName("currentLord")
    val currentLord: String,
    @SerializedName("diedOut")
    val diedOut: String,
    @SerializedName("founded")
    val founded: String,
    @SerializedName("founder")
    val founder: String,
    @SerializedName("heir")
    val heir: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("overlord")
    val overlord: String,
    @SerializedName("region")
    val region: String,
    @SerializedName("seats")
    val seats: List<String>,
    @SerializedName("swornMembers")
    val swornMembers: List<String>,
    @SerializedName("titles")
    val titles: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("words")
    val words: String
)