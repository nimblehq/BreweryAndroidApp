package com.example.macbook.breweryapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.macbook.breweryapp.R
import com.example.macbook.breweryapp.ui.github.GitHubViewModel
import com.example.macbook.breweryapp.ui.github.RepoAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val repoAdapter = RepoAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(GitHubViewModel::class.java)

        rv_list.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
            adapter = repoAdapter
        }

        viewModel.repos.observe(this, Observer {
            repoAdapter.setList(it)
        })

        viewModel.networkState.observe(this, Observer {
            repoAdapter.setNetworkState(it)
        })

    }
}
