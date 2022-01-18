package io.base86.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.autofleet.nivoot.manager.NivootLauncher
import io.base86.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // TODO: get token from network call, shared pref, local storage...
    fun getToken(): String {
        return "YOUR_TOKEN_HERE"
    }

    private val BASE_PATH = "BASE_PATH_HERE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setLisetners()
    }

    fun setLisetners() {
        binding.buttonStartSdkNavigation.setOnClickListener {
            NivootLauncher.startActivity(
                this,
                token=this.getToken(),
                wsUrl=BASE_PATH)
        }
    }
}