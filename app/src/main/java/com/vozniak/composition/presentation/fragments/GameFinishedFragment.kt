package com.vozniak.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vozniak.composition.R
import com.vozniak.composition.databinding.FragmentGameFinishedBinding
import com.vozniak.composition.domain.entity.GameResult
import com.vozniak.composition.domain.entity.GameSettings
import kotlinx.coroutines.flow.callbackFlow

class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
        binding.gameResult = args.gameResult
    }

    private fun setupClickListeners() {
        binding.buttonRetry.setOnClickListener() {
            initButtonRetry()
        }
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                initButtonRetry()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun initButtonRetry() {
        findNavController().popBackStack()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}