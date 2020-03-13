package com.miftarisimel.buckneer.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentDashboardBinding
import com.miftarisimel.buckneer.databinding.FragmentDashboardBindingImpl

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDashboardBinding.inflate(inflater)


        binding.textDashboard.setOnClickListener {
            this.findNavController().navigate(DashboardFragmentDirections.actionNavigationDashboardToTitleFragment())
        }



        return binding.root
    }
}