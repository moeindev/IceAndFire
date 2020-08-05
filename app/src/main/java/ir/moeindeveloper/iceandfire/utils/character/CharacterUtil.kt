package ir.moeindeveloper.iceandfire.utils.character

fun String.getQuoteCharacter(): QuoteCharacter {
    return when(this){
        "Bronn" -> QuoteCharacter.BRONN

        "Brynden Tully" -> QuoteCharacter.BRYNDEN_TULLY

        "Cersei" -> QuoteCharacter.CERSEI

        "The Hound" -> QuoteCharacter.THE_HOUND

        "Jaime Lannister" -> QuoteCharacter.JAIME_LANNISTER

        "Littlefinger" -> QuoteCharacter.LITTLE_FINGER

        "Olenna Tyrell" -> QuoteCharacter.OLENNA_TYRELL

        "Renly Baratheon" -> QuoteCharacter.RENLY_BARATHEON

        "Tyrion" -> QuoteCharacter.TYRION

        "Varys" -> QuoteCharacter.VARYS

        "Quaithe" -> QuoteCharacter.QUAITHE

        "Davos" -> QuoteCharacter.DAVOS

        "Bran" -> QuoteCharacter.BRAN

        "Sansa" -> QuoteCharacter.SANSA

        "Daenerys" -> QuoteCharacter.DAENERYS

        "Samwell" -> QuoteCharacter.SAMWELL

        "Cersei and Tyrion" -> QuoteCharacter.CERSEI_AND_TYRION

        "Jon Snow" -> QuoteCharacter.JON_SNOW

        "The Discarded Knight" -> QuoteCharacter.THE_DISCARDED_KNIGHT

        "Alayne" -> QuoteCharacter.ALAYNE

        "Lord Rodrik" -> QuoteCharacter.LORD_RODRIK

        "Victarion Greyjoy" -> QuoteCharacter.VICTARION_GREYJOY


        else -> QuoteCharacter.NONE
    }
}