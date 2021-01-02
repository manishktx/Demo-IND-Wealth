package com.demo.assignment.listing

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.databinding.ActivityReposBinding
import com.demo.assignment.listing.adapter.ReposListAdapter
import com.demo.assignment.listing.viewmodel.ReposViewModel
import com.demo.assignment.utils.callbacks.IItemClickCallback
import com.demo.assignment.utils.callbacks.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ReposListActivity : AppCompatActivity(),
    IItemClickCallback<ReposListingItem?> {

    private lateinit var binding: ActivityReposBinding
    private val viewModel: ReposViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityReposBinding.inflate(layoutInflater).apply {

            setContentView(root)

            recyclerView.addOnScrollListener(object : PaginationScrollListener() {
                override fun loadMoreItems() {
                    viewModel.loadRepos()
                }

                override fun isLastPage(): Boolean = viewModel.isLastPage

                override fun isLoading(): Boolean = viewModel.isLoading

            })

            with(this@ReposListActivity)
            {

                viewModel.repos.observe(this, { resource ->

                    resource.takeIf { it.isNotEmpty() }?.run {
                        recyclerView.adapter?.let {
                            (it as ReposListAdapter).updateData(this)
                        } ?: run {
                            recyclerView.adapter = ReposListAdapter(this, this@ReposListActivity)
                        }
                    }
                    viewModel.isLoading = false
                })
            }
        }

        viewModel.message.observe(this, {msg->
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        })

        viewModel.loadRepos()

    }

    override fun onItemClick(data: ReposListingItem?) {

    }
}


