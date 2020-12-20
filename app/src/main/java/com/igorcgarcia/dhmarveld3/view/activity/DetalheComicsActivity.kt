package com.igorcgarcia.dhmarveld3.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.igorcgarcia.dhmarveld3.R

class DetalheComicsActivity : AppCompatActivity() {

    var comicNumber: Int = 0

    private val ivDetalhePosterComic : ImageView by lazy {
        findViewById(R.id.ivDetalhePosterComic)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_comics)

        comicNumber = intent.getIntExtra("comicNumber", 0)
        Log.i("DetalheComicsActivity",comicNumber.toString())

        ivDetalhePosterComic.setOnClickListener {
            val intent = Intent(this, CoverDetalheActivity::class.java)
            intent.putExtra("comicNumber",comicNumber)
            startActivity(intent)
        }

    }
}