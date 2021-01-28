package com.raag.basketballscore.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Score(
    var scoreOne: Int,
    var scoreTwo: Int
) : Parcelable
