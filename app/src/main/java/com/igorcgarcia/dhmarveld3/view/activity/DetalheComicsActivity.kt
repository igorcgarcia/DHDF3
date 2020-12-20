package com.igorcgarcia.dhmarveld3.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.igorcgarcia.dhmarveld3.R

class DetalheComicsActivity : AppCompatActivity() {

    var comicNumber = 0
    var comicTitle = ""
    var comicDescription = ""
    var comicThumbnail = ""
    var comicDate = ""
    var comicPrice = ""
    var comicPage = 0

    private val ivDetalhePosterComic : ImageView by lazy {
        findViewById(R.id.ivDetalhePosterComic)
    }

    private val tvDetalheTitulo : TextView by lazy {
        findViewById(R.id.tvDetalheTitulo)
    }

    private val tvDetalheDescricao : TextView by lazy {
        findViewById(R.id.tvDetalheDescricao)
    }

    private val tvDetalhePublicadoValor : TextView by lazy {
        findViewById(R.id.tvDetalhePublicadoValor)
    }

    private val tvDetalhePrecoValor : TextView by lazy {
        findViewById(R.id.tvDetalhePrecoValor)
    }

    private val tvDetalhePaginasValor : TextView by lazy {
        findViewById(R.id.tvDetalhePaginasValor)
    }

    private val ivDetalheCover : ImageView by lazy {
        findViewById(R.id.ivDetalheCover)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_comics)

        comicNumber = intent.getIntExtra("comicNumber", 0)
        comicTitle = intent.getStringExtra("comicTitle").toString()
        comicDate = intent.getStringExtra("comicDate").toString()
        comicDescription = intent.getStringExtra("comicDescription").toString()
        comicThumbnail = intent.getStringExtra("comicThumbnail").toString()
        comicPrice = intent.getStringExtra("comicPrice").toString()
        comicPage = intent.getIntExtra("comicPage",0)

        Log.i("DetalheComicsActivity", comicNumber.toString())

        Glide.with(ivDetalhePosterComic.context)
            .load(comicThumbnail.replace("http:","https:"))
            .centerInside()
            .into(ivDetalhePosterComic)

        Glide.with(ivDetalheCover.context)
            .load(comicThumbnail.replace("http:","https:"))
            .centerCrop()
            .into(ivDetalheCover)

        tvDetalheTitulo.text = comicTitle
        tvDetalheDescricao.text = comicDescription
        tvDetalhePublicadoValor.text = comicDate
        tvDetalhePrecoValor.text = comicPrice
        tvDetalhePaginasValor.text = comicPage.toString()

        ivDetalhePosterComic.setOnClickListener {
            val intent = Intent(this, CoverDetalheActivity::class.java)
            intent.putExtra("comicNumber",comicNumber)
            startActivity(intent)
        }

    }
}