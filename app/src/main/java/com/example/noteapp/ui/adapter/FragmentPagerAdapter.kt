package com.example.noteapp.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragments.OnBoardPagerFragment
import com.example.noteapp.ui.fragments.OnBoardPagerFragment.Companion.KEY

class FragmentPagerAdapter (
    fragment: Fragment
        ) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagerFragment().apply {
        arguments = Bundle().apply {
            putInt(KEY, position)
        }
    }
}