package ir.moeindeveloper.iceandfire.data.preference

import android.content.SharedPreferences
import ir.moeindeveloper.iceandfire.utils.character.QuoteCharacter
import ir.moeindeveloper.iceandfire.utils.character.getQuoteCharacter
import javax.inject.Inject

class SettingsPreference @Inject constructor(private val preference: SharedPreferences) {

    private val isCharacterSavedKey: String = "ice_is_saved"
    private val characterKey: String = "ice_character"


    fun saveCharacter(character: QuoteCharacter){
        preference.edit().putString(characterKey,character.characterName).apply()
        saveCharacterIsSaved(true)
    }

    fun saveCharacterIsSaved(boolean: Boolean){
        preference.edit().putBoolean(isCharacterSavedKey,boolean).apply()
    }

    fun isCharacterSaved(): Boolean = preference.getBoolean(isCharacterSavedKey,false)

    fun getCharacter(): QuoteCharacter = preference.getString(characterKey,"none")!!.getQuoteCharacter()
}