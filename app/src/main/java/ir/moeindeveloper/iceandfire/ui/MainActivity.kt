package ir.moeindeveloper.iceandfire.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import ir.moeindeveloper.iceandfire.R
import ir.moeindeveloper.iceandfire.viewModel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm.quote.observe(this, Observer {
            Log.e("qoute",it.toString())
        })
    }
}