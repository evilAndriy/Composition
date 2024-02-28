package com.vozniak.composition.domain.usecases

import com.vozniak.composition.domain.entity.Question
import com.vozniak.composition.domain.repository.GameRepository

class GenerateQuestionsUseCase(private val repository: GameRepository) {
    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestions(maxSumValue, COUNT_OF_OPTIONS)
    }


    companion object {
        private const val COUNT_OF_OPTIONS = 6
    }
}