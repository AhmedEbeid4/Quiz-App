package com.example.quizapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.Communicator
import com.example.quizapp.MainActivity
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentStartBinding
import com.example.quizapp.model.Question
import com.example.quizapp.model.Questions


class StartFragment : Fragment() {
    private lateinit var communicator: Communicator
    private lateinit var binding:FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        communicator = activity as (MainActivity)
        binding.startBtn.setOnClickListener {
            communicator.onExamStarted()
        }
        return binding.root
    }

}