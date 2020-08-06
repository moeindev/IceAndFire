package ir.moeindeveloper.iceandfire.utils.theme

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import javax.inject.Inject

class ThemeManager @Inject constructor(private val preferences : SharedPreferences) {



    private val themeKey: String = "preference_key_theme"

    fun initTheme() {
        val theme = getCurrentTheme()
        applyTheme(theme)
    }

    fun getCurrentTheme(): ThemePreference {
        return when(preferences.getString(themeKey,"")){
            ThemePreference.LIGHT_MODE.themeName -> ThemePreference.LIGHT_MODE
            ThemePreference.DARK_MODE.themeName -> ThemePreference.DARK_MODE
            ThemePreference.FOLLOW_SYSTEM_MODE.themeName -> ThemePreference.FOLLOW_SYSTEM_MODE
            else -> ThemePreference.FOLLOW_SYSTEM_MODE
        }
    }

    private fun applyTheme(themePreference: ThemePreference) {
        when (themePreference) {
            ThemePreference.LIGHT_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            ThemePreference.DARK_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            ThemePreference.AUTO_BATTERY_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            ThemePreference.FOLLOW_SYSTEM_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }


    fun changeTheme(theme: ThemePreference) {
        when (theme) {
            ThemePreference.LIGHT_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            ThemePreference.DARK_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            ThemePreference.AUTO_BATTERY_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY)
            ThemePreference.FOLLOW_SYSTEM_MODE -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        preferences.edit().putString(themeKey,theme.themeName).apply()
    }
}