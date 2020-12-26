package com.igorcgarcia.dhmarveld3.view.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.igorcgarcia.dhmarveld3.R
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_NUMBER
import com.igorcgarcia.dhmarveld3.util.Constants.ComicsDetail.KEY_INTENT_COMIC_THUMBNAIL

class CoverDetalheActivity : AppCompatActivity() {

    var comicNumber: Int = 0
    var comicThumbnail = ""

    private val ivCoverPosterComic : ImageView by lazy {
        findViewById(R.id.ivCoverPosterComic)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cover_detalhe)

        comicNumber = intent.getIntExtra(KEY_INTENT_COMIC_NUMBER, 0)
        comicThumbnail = intent.getStringExtra(KEY_INTENT_COMIC_THUMBNAIL).toString()
//        Log.i("CoverDetalheActivity",comicNumber.toString())
//        Log.i("CoverDetalheActivity",comicThumbnail)

        Glide.with(ivCoverPosterComic.context)
                .load(comicThumbnail.replace("http:","https:"))
                .centerInside()
                .into(ivCoverPosterComic)
    }
}