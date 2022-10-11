package com.example.quizapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.R
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.model.Questions


class ResultFragment() : Fragment() {
    private lateinit var binding:FragmentResultBinding
    private var result: Int=0
    constructor(result:Int) : this() {
        this.result=result
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentResultBinding.inflate(layoutInflater,container,false)
        if(result != -1){
         binding.resultText.text="$result / ${Questions.get().size}"
        }
        return binding.root
    }
}