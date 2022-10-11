package com.example.quizapp.model

class Questions {
    companion object{
        private lateinit var questions:ArrayList<Question>
        fun get():ArrayList<Question>{
            questions= ArrayList()
            questions.add(Question(
                "1 + 1 = ?",
                mutableListOf<String>("2","4","5","6"),
                0
            ))
            questions.add(Question(
                "1 + 1 = ?",
                mutableListOf<String>("2","4","5","6"),
                0
            ))
            questions.add(Question(
                "1 + 1 = ?",
                mutableListOf<String>("2","4","5","6"),
                0
            ))
            questions.add(Question(
                "1 + 1 = ?",
                mutableListOf<String>("2","4","5","6"),
                0
            ))
            return questions
        }
    }
}