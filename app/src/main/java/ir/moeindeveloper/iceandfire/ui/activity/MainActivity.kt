package ir.moeindeveloper.iceandfire.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ir.moeindeveloper.iceandfire.R
import ir.moeindeveloper.iceandfire.databinding.ActivityMainBinding
import ir.moeindeveloper.iceandfire.viewModel.MainViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navHost: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        navHost = supportFragmentManager.findFragmentById(R.id.main_host) as NavHostFragment
    }
}