package com.vozniak.composition.domain.entity

import java.io.Serializable

data class GameResult(
    val winner : Boolean,
    val countOfRightAnswers : Int,
    val countOfQuestions: Questions,
    val gameSettings: GameSettings
) : Serializable