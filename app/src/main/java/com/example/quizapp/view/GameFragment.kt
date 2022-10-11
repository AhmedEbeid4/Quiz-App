package com.example.quizapp.view

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quizapp.Communicator
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentGameBinding
import com.example.quizapp.model.Question
import com.example.quizapp.model.Questions

class GameFragment(private val currIndex:Int, private val currResult:Int) : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private lateinit var communicator: Communicator
    private lateinit var question: Question
    private  var chosenChoice:Int=-1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        question=Questions.get()[currIndex]
        binding.question.text=question.qu
        addingChoices()
        communicator = activity as (MainActivity)
        actions()
        return binding.root
    }

    private fun addingChoices(){
        binding.answer1.text=question.choices[0]
        binding.answer2.text=question.choices[1]
        binding.answer3.text=question.choices[2]
        binding.answer4.text=question.choices[3]
    }

    private fun actions(){
        submitBtnAction()
        choicesAction()
    }
    private fun submitBtnAction(){
        binding.submitBtn.setOnClickListener {
            if(chosenChoice != -1){

                communicator.finishedQuestion(currIndex+1,checkIfTrue())
            }else{
                Toast.makeText(activity?.applicationContext,"You should choose !",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun checkIfTrue():Int{
        return if (chosenChoice == question.answer){
            currResult+1
        }else{
            currResult
        }
    }
    private fun choicesAction(){
        binding.answer1.setOnClickListener {
            chosenChoice=0
            binding.answer1.setTypeface(null, Typeface.BOLD);
            binding.answer1.setBackgroundResource(R.drawable.selected_choice)

            binding.answer2.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer2.setTypeface(null, Typeface.NORMAL);

            binding.answer3.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer3.setTypeface(null, Typeface.NORMAL);

            binding.answer4.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer4.setTypeface(null, Typeface.NORMAL);

        }
        binding.answer2.setOnClickListener {
            chosenChoice=1
            binding.answer2.setTypeface(null, Typeface.BOLD);
            binding.answer2.setBackgroundResource(R.drawable.selected_choice)

            binding.answer3.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer3.setTypeface(null, Typeface.NORMAL);

            binding.answer4.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer4.setTypeface(null, Typeface.NORMAL);

            binding.answer1.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer1.setTypeface(null, Typeface.NORMAL);

        }
        binding.answer3.setOnClickListener {
            chosenChoice=2
            binding.answer3.setTypeface(null, Typeface.BOLD);
            binding.answer3.setBackgroundResource(R.drawable.selected_choice)

            binding.answer4.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer4.setTypeface(null, Typeface.NORMAL);

            binding.answer2.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer2.setTypeface(null, Typeface.NORMAL);

            binding.answer1.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer1.setTypeface(null, Typeface.NORMAL);

        }
        binding.answer4.setOnClickListener {
            chosenChoice=3
            binding.answer4.setTypeface(null, Typeface.BOLD);
            binding.answer4.setBackgroundResource(R.drawable.selected_choice)

            binding.answer3.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer3.setTypeface(null, Typeface.NORMAL);

            binding.answer2.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer2.setTypeface(null, Typeface.NORMAL);

            binding.answer1.setBackgroundResource(R.drawable.normal_answer_back)
            binding.answer1.setTypeface(null, Typeface.NORMAL);

        }
    }
}