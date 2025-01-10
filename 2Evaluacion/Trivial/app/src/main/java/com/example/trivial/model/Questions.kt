package com.example.trivial.model

import com.example.trivial.data.QuestionData
import com.example.trivial.data.videoGameQuestions

data class Questions(val videoGameQuestions: QuestionData) {}

fun getRandomQuestions(numberOfQuestions: Int=5): List<QuestionData> {
    return videoGameQuestions.shuffled().take(numberOfQuestions) }