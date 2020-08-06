package ir.moeindeveloper.iceandfire

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import ir.moeindeveloper.iceandfire.utils.theme.ThemeManager
import javax.inject.Inject

/*
Step 1: Add @HiltAndroidApp to your application class
 */
@HiltAndroidApp
class IceAndFireApplication: Application() {

    @Inject
    lateinit var themeManager: ThemeManager


    override fun onCreate() {
        super.onCreate()
        themeManager.initTheme()
    }
}