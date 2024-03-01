package com.vozniak.composition.data

import com.vozniak.composition.domain.entity.GameSettings
import com.vozniak.composition.domain.entity.Level
import com.vozniak.composition.domain.entity.Question
import com.vozniak.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestions(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }

            Level.EASY -> {
                GameSettings(
                    20,
                    10,
                    70,
                    60
                )
            }

            Level.NORMAL -> {
                GameSettings(
                    35,
                    12,
                    80,
                    75
                )
            }

            Level.HARD -> {
                GameSettings(
                    50,
                    15,
                    90,
                    80
                )
            }
        }
    }
}