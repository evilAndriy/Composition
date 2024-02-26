package com.vozniak.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
           initFragment(GameFragment.newInstance(Level.TEST))
       }
       binding.buttonLevelEasy.setOnClickListener(){
           initFragment(GameFragment.newInstance(Level.EASY))
       }
       binding.buttonLevelNormal.setOnClickListener(){
           initFragment(GameFragment.newInstance(Level.NORMAL))
       }
       binding.buttonLevelHard.setOnClickListener(){
           initFragment(GameFragment.newInstance(Level.HARD))
       }
    }
    private fun initFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.
        beginTransaction().
        replace(R.id.place_holder, fragment).
        addToBackStack(GameFragment.NAME).
        commit()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val NAME = "ChooseLevelFragment"
        fun newInstance() = ChooseLevelFragment()
    }
}