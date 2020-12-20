package com.igorcgarcia.dhmarveld3.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ComicList(
    val comicImage: Int,
    val comicNumber: Int
) : Parcelable