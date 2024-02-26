package com.vozniak.composition.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vozniak.composition.R
import com.vozniak.composition.databinding.FragmentGameBinding
import com.vozniak.composition.domain.entity.GameResult
import com.vozniak.composition.domain.entity.GameSettings
import com.vozniak.composition.domain.entity.Level
import com.vozniak.composition.domain.entity.Questions

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")

    // initial
    private lateinit var level: Level
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOption1.setOnClickListener() {
            initFragment(GameFinishedFragment.newInstance(GameResult(
                        true,
                        0,
                        0,
                        GameSettings(
                            0,
                            0,
                            0,
                            0
                        )
                    )
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable(KEY_LEVEL, Level::class.java).let {
            level = it as Level
        }
    }

    private fun initFragment(fragment: Fragment) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.place_holder, fragment).addToBackStack(null).commit()
    }

    companion object {
        private const val KEY_LEVEL = "key_level"
        const val NAME = "GameFragment"
        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}