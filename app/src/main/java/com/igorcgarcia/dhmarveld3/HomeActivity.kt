package com.igorcgarcia.dhmarveld3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

//    private val rvListComics : RecyclerView by lazy {
//        findViewById(R.id.rvListComics)
//    }

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

        findViewById<RecyclerView>(R.id.rvListComics).apply {
            layoutManager = GridLayoutManager(
                this@HomeActivity, 3,
                GridLayoutManager.VERTICAL, false
            )
            adapter = ComicsAdapter(comics) { position ->
//                val intent = Intent(this@DetalheMenuActivity, DetalheEscolhaMenuActivity::class.java)
//                intent.putExtra(KEY_INTENT_MENU,menuEscolha[position])
//                startActivity(intent)
//            }
            }

        }
    }
}