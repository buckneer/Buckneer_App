package com.miftarisimel.buckneer.ui.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miftarisimel.buckneer.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentProfileBinding.inflate(inflater)



        return binding.root

    }



}
