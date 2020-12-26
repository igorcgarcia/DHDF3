package com.igorcgarcia.dhmarveld3.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.igorcgarcia.dhmarveld3.R
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_DATE
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_DESC
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_NUMBER
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_PAGE
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_PRICE
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_THUMBNAIL
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_TITLE
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_comics)

        comicNumber = intent.getIntExtra(KEY_INTENT_COMIC_NUMBER, 0)
        comicTitle = intent.getStringExtra(KEY_INTENT_COMIC_TITLE).toString()
        comicDescription = intent.getStringExtra(KEY_INTENT_COMIC_DESC).toString()
        comicDate = intent.getStringExtra(KEY_INTENT_COMIC_DATE).toString()
        comicThumbnail = intent.getStringExtra(KEY_INTENT_COMIC_THUMBNAIL).toString()
        comicPrice = intent.getDoubleExtra(KEY_INTENT_COMIC_PRICE, 0.00).toString()
        comicPage = intent.getIntExtra(KEY_INTENT_COMIC_PAGE,0)

        val formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
        val dataComic = LocalDate.parse(comicDate.substring(0, 19), DateTimeFormatter.ISO_LOCAL_DATE_TIME)

//        Log.i("DetalheComicsActivity", comicNumber.toString())
//        Log.i("DetalheComicsActivity", dataComic.format(formatter))

        Glide.with(ivDetalhePosterComic.context)
            .load(comicThumbnail.replace("http:","https:"))
            .centerInside()
            .into(ivDetalhePosterComic)

        Glide.with(ivDetalheCover.context)
            .load(comicThumbnail.replace("http:","https:"))
            .centerCrop()
            .into(ivDetalheCover)

        tvDetalheTitulo.text = comicTitle
        tvDetalheDescricao.text = if(comicDescription != "null") comicDescription else ""
        tvDetalhePublicadoValor.text = dataComic.format(formatter)
        tvDetalhePrecoValor.text = if (comicPrice.length>0) "$ ${comicPrice}" else ""
        tvDetalhePaginasValor.text = comicPage.toString()

        ivDetalhePosterComic.setOnClickListener {
            val intent = Intent(this, CoverDetalheActivity::class.java)
            intent.putExtra(KEY_INTENT_COMIC_NUMBER,comicNumber)
            intent.putExtra(KEY_INTENT_COMIC_THUMBNAIL,comicThumbnail)
            startActivity(intent)
        }

    }
}