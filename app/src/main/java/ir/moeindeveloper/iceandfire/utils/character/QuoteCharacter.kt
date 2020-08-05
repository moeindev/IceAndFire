package ir.moeindeveloper.iceandfire.utils.character

import androidx.annotation.DrawableRes
import ir.moeindeveloper.iceandfire.R

enum class QuoteCharacter(val characterName: String, val queryName: String, @DrawableRes image: Int?) {

    NONE("","", R.drawable.char_default),
    BRONN("Bronn","bronn", R.drawable.char_bronn),
    BRYNDEN_TULLY("Brynden Tully","brynden",R.drawable.char_brynden_tully),
    CERSEI("Cersei Lannister","cersei",R.drawable.char_cersei),
    THE_HOUND("The Hound","hound",R.drawable.char_the_hound),
    JAIME_LANNISTER("Jaime Lannister","jaime",R.drawable.char_jaime_lannister),
    LITTLE_FINGER("Littlefinger","littlefinger",R.drawable.char_littlefinger),
    OLENNA_TYRELL("Olenna Tyrell","olenna",R.drawable.char_olenna_tyrell),
    RENLY_BARATHEON("Renly Baratheon","renly",R.drawable.char_renly_baratheon),
    TYRION("Tyrion","tyrion",R.drawable.char_tyrion),
    VARYS("Varys","varys",R.drawable.char_varys),

    QUAITHE("Quaithe","quaithe",R.drawable.char_quaithe),
    DAVOS("Davos","char_davos",R.drawable.char_davos),
    BRAN("Bran","bran",R.drawable.char_bran),
    SANSA("Sansa","sansa",R.drawable.char_sansa),
    DAENERYS("Daenerys","daenerys",R.drawable.char_daenerys),
    SAMWELL("Samwell","samwell",R.drawable.char_samwell),
    CERSEI_AND_TYRION("Cersei and Tyrion","cersei and tyrion",R.drawable.char_cersei_and_tyrion),
    JON_SNOW("Jon Snow","Jon Snow",R.drawable.char_jon_snow),


    //no Pics:
    THE_DISCARDED_KNIGHT("The Discarded Knight","The Discarded Knight",R.drawable.char_default),
    ALAYNE("Alayne","alayne",R.drawable.char_default),
    LORD_RODRIK("Lord Rodrik", "lord rodrik",R.drawable.char_default),
    VICTARION_GREYJOY("Victarion Greyjoy","victarion greyjoy",R.drawable.char_default)


}