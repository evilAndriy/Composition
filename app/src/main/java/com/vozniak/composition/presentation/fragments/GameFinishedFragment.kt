package com.vozniak.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vozniak.composition.databinding.FragmentGameFinishedBinding
import com.vozniak.composition.domain.entity.GameResult
import com.vozniak.composition.domain.entity.GameSettings

class GameFinishedFragment : Fragment() {
    private var _binding: FragmentGameFinishedBinding? = null
    private val binding: FragmentGameFinishedBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    private lateinit var gameResult: GameSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        gameResult = requireArguments().getSerializable(
            GAME_RESULT_KEY,
            GameSettings::class.java
        ) as GameSettings
    }

    companion object {
        private const val GAME_RESULT_KEY = "game_finished"
        fun newInstance(gameSettings: GameSettings): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(GAME_RESULT_KEY, gameSettings)
                }
            }
        }
    }
}