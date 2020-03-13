package com.miftarisimel.buckneer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import com.miftarisimel.buckneer.R
import com.miftarisimel.buckneer.databinding.FragmentHomeBinding
import com.miftarisimel.buckneer.models.Category
import com.miftarisimel.buckneer.models.Project
import com.miftarisimel.buckneer.ui.common.BaseFragment
import com.miftarisimel.buckneer.ui.common.setupAuthGuard

class HomeFragment : BaseFragment(), HomeAdapter.Listener {

    override fun sendMessage(projectId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBids(postId: String, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bid(projectId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mViewModel: HomeViewModel
    private lateinit var mHomeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //val root = inflater.inflate(R.layout.fragment_home, container, false)
        val binding = FragmentHomeBinding.inflate(inflater)

        mHomeAdapter = HomeAdapter(this)


        binding.projectsRecycler.adapter = mHomeAdapter
        binding.projectsRecycler.layoutManager = LinearLayoutManager(activity!!)



        setupAuthGuard {uid ->
            mViewModel = initViewModel()
            mViewModel.init(uid)
            mViewModel.projects.observe(viewLifecycleOwner, Observer {
                it?.let {
                    mHomeAdapter.updatePosts(it)
                }
            })


        }


        return binding.root
    }


}