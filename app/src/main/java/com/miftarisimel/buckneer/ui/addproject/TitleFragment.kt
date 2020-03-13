package com.miftarisimel.buckneer.ui.addproject

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTitleBinding.inflate(inflater)
        binding.continueButton.setOnClickListener {
            val projectTitle = binding.projectTitle.text.toString()

            this.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToAddProjectFragment(projectTitle))
        }



        return binding.root

    }

}
