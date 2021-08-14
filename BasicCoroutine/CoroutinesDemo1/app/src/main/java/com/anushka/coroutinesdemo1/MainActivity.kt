package com.anushka.coroutinesdemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCount.setOnClickListener {

        }
        btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private suspend fun downloadUserData() {
        for (i in 1..200000) {
            withContext(Dispatchers.Main) {
                tvCount.text = count++.toString()
                delay(1000)
            }
        }
    }
}
