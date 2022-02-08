package io.base86.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.autofleet.nivoot.manager.NivootLauncher
import io.base86.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // TODO: get token from network call, shared pref, local storage...
    fun getToken(): String {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZWhpY2xlSWQiOiJhMDA0ZWNmZS1mZGRiLTQ2OTYtOTdmYy03YWQ1NGQ5YmI3OTEiLCJpYXQiOjE2NDI1ODU1NTB9.oJicp0QJaCuXz0xO5xb8rWJksPkfD4l0ucoXZm3p_E8"
    }

    private val BASE_PATH = "driver-gateway.autofleet.io"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setLisetners()
    }

    // when clicking back button
    fun onCloseHandler() {
        Log.d("MainActivity", "nivoot has been closed")
    }

    fun setLisetners() {
        binding.buttonStartSdkNavigation.setOnClickListener {
            NivootLauncher.startActivity(
                this,
                onClose=::onCloseHandler,
                token=this.getToken(),
                wsUrl=BASE_PATH)
        }
    }
}