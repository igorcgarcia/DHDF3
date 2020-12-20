package com.igorcgarcia.dhmarveld3.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.igorcgarcia.dhmarveld3.R

class CoverDetalheActivity : AppCompatActivity() {

    var comicNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover_detalhe)

        comicNumber = intent.getIntExtra("comicNumber", 0)
        Log.i("CoverDetalheActivity",comicNumber.toString())


    }
}