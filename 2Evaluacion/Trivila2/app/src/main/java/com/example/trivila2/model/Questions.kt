package com.example.trivila2.model

import com.example.trivila2.data.QuestionData
import com.example.trivila2.data.videoGameQuestions

data class Questions(val videoGameQuestions: QuestionData) {}

fun getRandomQuestions(numberOfQuestions: Int=5): List<QuestionData> {
    return videoGameQuestions.shuffled().take(numberOfQuestions) }