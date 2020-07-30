package ir.moeindeveloper.iceandfire.data.pojo.quote


import com.google.gson.annotations.SerializedName


data class Quote(
    @SerializedName("character")
    val character: String,
    @SerializedName("quote")
    val quote: String
)