package com.igorcgarcia.dhmarveld3.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.igorcgarcia.dhmarveld3.R
import com.igorcgarcia.dhmarveld3.model.ComicList
import com.igorcgarcia.dhmarveld3.view.adapter.ComicsAdapter
import com.igorcgarcia.dhmarveld3.viewModel.MarvelViewModel

class HomeActivity : AppCompatActivity() {

//    private val rvListComics : RecyclerView by lazy {
//        findViewById(R.id.rvListComics)
//    }

    private lateinit var viewModel: MarvelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        iniComponents()
    }

    private fun iniComponents() {

        val comics = mutableListOf<ComicList>()

        comics.add(ComicList(R.drawable.image_comic_example, 1))
        comics.add(ComicList(R.drawable.image_comic_example, 2))
        comics.add(ComicList(R.drawable.image_comic_example, 3))
        comics.add(ComicList(R.drawable.image_comic_example, 4))
        comics.add(ComicList(R.drawable.image_comic_example, 5))
        comics.add(ComicList(R.drawable.image_comic_example, 6))

        viewModel = ViewModelProvider(this).get(MarvelViewModel::class.java)
        viewModel.getComics()


        viewModel.comicsLiveData.observe(this){ marvel ->
            findViewById<RecyclerView>(R.id.rvListComics).apply {
                layoutManager = GridLayoutManager(
                    this@HomeActivity, 3,
                    GridLayoutManager.VERTICAL, false
                )
                adapter = ComicsAdapter(marvel.data.results) { position ->
                    val intent = Intent(this@HomeActivity, DetalheComicsActivity::class.java)
                    intent.putExtra("comicNumber",marvel.data.results[position].id)
                    intent.putExtra("comicTitle",marvel.data.results[position].title)
                    intent.putExtra("comicDescription", marvel.data.results[position].description)

                    marvel.data.results[position].dates.forEach(){
                        if (it.type == "onsaleDate"){
                            intent.putExtra("comicDate", it.date)
                        }
                    }

                    marvel.data.results[position].prices.forEach(){
                        if (it.type == "printPrice"){
                            intent.putExtra("comicPrice", it.price)
                        }
                    }

                    intent.putExtra("comicPage",marvel.data.results[position].pageCount)
                    intent.putExtra("comicThumbnail", "${marvel.data.results[position].thumbnail.path}.${marvel.data.results[position].thumbnail.extension}")
                    startActivity(intent)
                }

            }
        }
    }
}
