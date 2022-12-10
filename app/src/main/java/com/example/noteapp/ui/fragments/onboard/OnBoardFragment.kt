package com.example.noteapp.ui.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adapter.FragmentPagerAdapter
import com.example.noteapp.utils.PreferenceHelper
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
        setOnClickListener()
        transition()
    }

    private fun initialize() = with(binding.viewPager) {
        adapter = FragmentPagerAdapter(this@OnBoardFragment)
    }

    // Логика всех кликов
    private fun setOnClickListener() = with(binding) {
        // Клик на "Пропусить"
        skip.setOnClickListener {
            if (viewPager.currentItem < 3)
                viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
        // Логика View Pager(a)
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvStartWork.isVisible = false
                        skip.isVisible = true
                    }
                    1 -> {
                        tvStartWork.isVisible = false
                        skip.isVisible = true
                    }
                    2 -> {
                        tvStartWork.isVisible = true
                        skip.isVisible = false
                    }
                }
                super.onPageSelected(position)
            }
        })
        // Клик на "Начать работу"
        tvStartWork.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)
        }
        // Наш индикатор
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, pos ->
        } .attach()
    }

    private fun transition() {
        if (PreferenceHelper.showOnBoard){
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)
        }else {
            PreferenceHelper.showOnBoard = true
        }
    }
}