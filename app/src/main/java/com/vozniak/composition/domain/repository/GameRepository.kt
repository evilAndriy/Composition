package com.vozniak.composition.domain.repository

import com.vozniak.composition.domain.entity.GameSettings
import com.vozniak.composition.domain.entity.Level
import com.vozniak.composition.domain.entity.Question

interface GameRepository {
    fun generateQuestions(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Level): GameSettings
}