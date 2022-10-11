package com.example.quizapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.model.Questions
import com.example.quizapp.view.GameFragment
import com.example.quizapp.view.ResultFragment
import com.example.quizapp.view.StartFragment

class MainActivity : AppCompatActivity(),Communicator {
    private lateinit var binding:ActivityMainBinding

    private lateinit var trans: FragmentTransaction
    private lateinit var startFragment: StartFragment
    private lateinit var gameFragment:GameFragment
    private lateinit var resultFragment: ResultFragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        assignComponents()
    }
    private fun assignComponents(){
        startFragment= StartFragment()
        gameFragment= GameFragment(0,0)
        resultFragment= ResultFragment()
        fragmentManager=supportFragmentManager
        trans=fragmentManager.beginTransaction()
        add(startFragment)
    }

    private fun replace(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.from_left_to_right,R.anim.from_right_to_left)
        transaction.replace(binding.frame.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun add(fragment: Fragment) {
        trans.setCustomAnimations(R.anim.from_left_to_right,R.anim.from_right_to_left)
        trans.add(binding.frame.id,fragment)
        trans.addToBackStack(null)
        trans.commit()
    }
    override fun onExamStarted() {
        replace(gameFragment)
    }

    override fun finishedQuestion(index: Int,currResult:Int) {
        if(index < Questions.get().size){
            replace(GameFragment(index,currResult))
        }else{
            replace(ResultFragment(currResult))
        }
    }


}