package com.myu.myutvshowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.myu.myutvshowapp.adapter.TvShowAdapter
import com.myu.myutvshowapp.databinding.ActivityMainBinding
import com.myu.myutvshowapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel: TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter : TvShowAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        setupRv()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.responseTvShow.observe(this,{ response ->
            tvShowAdapter.tvShows = response


        })
    }

    private fun setupRv() {
        tvShowAdapter = TvShowAdapter()

        binding.rvTvShows.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)

        }

        binding.rvRecentlyAdded.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)

        }

        binding.rvEpisodes.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(
                this@MainActivity,LinearLayoutManager.HORIZONTAL,
                false
            )
            setHasFixedSize(true)

        }
    }



}