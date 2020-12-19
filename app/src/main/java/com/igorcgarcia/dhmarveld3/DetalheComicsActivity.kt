package com.igorcgarcia.dhmarveld3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetalheComicsActivity : AppCompatActivity() {

    var comicNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_comics)

        comicNumber = intent.getIntExtra("comicNumber", 0)
        Log.i("DetalheComicsActivity",comicNumber.toString())
    }
}