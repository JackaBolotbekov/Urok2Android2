package com.example.noteapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardPagerBinding

class OnBoardPagerFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(KEY)) {
            0 -> {
                tvText.text = "Очень удобный функционал"
                lottieAnimation.setAnimation(R.raw.lottie1)
            }
            1 -> {
                tvText.text = "Быстрый, качественный продукт"
                lottieAnimation.setAnimation(R.raw.lottie2)
            }
            2 -> {
                tvText.text = "Куча функций и интересных фишек"
                lottieAnimation.setAnimation(R.raw.lottie3)
            }
        }
    }

    companion object {
        const val KEY = "oBoard"
    }
}