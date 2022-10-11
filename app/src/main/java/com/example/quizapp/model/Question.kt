package com.example.quizapp.model

data class Question(val qu:String, val choices: MutableList<String>, val answer:Int) {
}