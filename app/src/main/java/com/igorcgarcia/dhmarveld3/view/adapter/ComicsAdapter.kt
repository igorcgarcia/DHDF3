package com.igorcgarcia.dhmarveld3.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.igorcgarcia.dhmarveld3.R
import com.igorcgarcia.dhmarveld3.model.ComicList

class ComicsAdapter(private val comicList : List<ComicList>,
                    private val onItemClicked : (Int) -> Unit
) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_grid_poster,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comicList[position],onItemClicked)
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private lateinit var ivPosterComic : ImageView
        private lateinit var tvPosterComic : TextView

        fun bind(list : ComicList, onItemMenuClicked: (Int) -> Unit) = with(itemView) {

            ivPosterComic = findViewById<ImageView>(R.id.ivPosterComic)
            tvPosterComic = findViewById<TextView>(R.id.tvPosterComic)

            Glide.with(itemView.context).load(list.comicImage).into(ivPosterComic)
            ("#" + list.comicNumber).also { tvPosterComic.text = it }

            ivPosterComic.setOnClickListener {
                onItemMenuClicked(this@ViewHolder.adapterPosition)
            }

        }
    }
}
