package com.example.quizapp

interface Communicator {
    fun onExamStarted()
    fun finishedQuestion(index:Int,currResult:Int)
}