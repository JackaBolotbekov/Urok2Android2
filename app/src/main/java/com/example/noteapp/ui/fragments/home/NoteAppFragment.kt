package com.example.noteapp.ui.fragments.home

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.databinding.FragmentNoteAppBinding
import com.example.noteapp.utils.PreferenceHelper

class NoteAppFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }
}