package com.vozniak.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vozniak.composition.R
import com.vozniak.composition.databinding.FragmentChooseLevelBinding
import com.vozniak.composition.domain.entity.Level

class ChooseLevelFragment  : Fragment() {
    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initButtons()
    }

   private fun initButtons(){
       binding.buttonLevelTest.setOnClickListener(){
           initFragment(Level.TEST)
       }
       binding.buttonLevelEasy.setOnClickListener(){
           initFragment(Level.EASY)
       }
       binding.buttonLevelNormal.setOnClickListener(){
           initFragment(Level.NORMAL)
       }
       binding.buttonLevelHard.setOnClickListener(){
           initFragment(Level.HARD)
       }
    }
    private fun initFragment(level: Level) {
        findNavController().navigate(ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(level))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}