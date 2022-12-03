package com.example.noteapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapter.FragmentPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        clickText()
        scrollPager()
        homeClick()
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ _, _ ->
        } .attach()
    }

    private fun initialize() {
        binding.viewPager.adapter = FragmentPagerAdapter(this@OnBoardFragment)
    }

    private fun homeClick() {
        binding.tvStartWork.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)
        }
    }

    private fun scrollPager() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvStartWork.isInvisible = true
                        skip.isVisible = true
                    }
                    1 -> {
                        tvStartWork.isInvisible = true
                        skip.isVisible = true
                    }
                    2 -> {
                        tvStartWork.isVisible = true
                        skip.isInvisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

    private fun clickText() = with(binding.viewPager) {
        binding.skip.setOnClickListener {
            if (currentItem < 3)
                setCurrentItem(currentItem + 1, true)
        }
    }
}