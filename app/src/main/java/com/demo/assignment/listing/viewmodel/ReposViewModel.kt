package com.demo.assignment.listing.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.data.repository.ReposRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.set
import com.demo.assignment.data.Result

class ReposViewModel @ViewModelInject constructor(private val repository: ReposRepository) : ViewModel() {

    var repos = MutableLiveData<List<ReposListingItem>>()
    var message = MutableLiveData<String>()

    var isLastPage = false
    var isLoading = true

    private var queryMap = HashMap<String, Any>()

    init {
        resetQuery()
    }

    fun loadRepos() {
        isLoading = true
        queryMap["page"] = queryMap["page"].toString().toInt()+1

        viewModelScope.launch {
            repository.loadRepos(queryMap).collect{
                when(it)
                {
                    Result.Loading ->
                    {
                        message.value = "Loading page."
                    }
                    is Result.Success -> {
                        repos.value = it.data
                    }
                    is Result.Error ->{
                        isLastPage = true
                        message.value = it.error

                    }
                }
            }
        }

    }

    private fun resetQuery() {
        queryMap["per_page"] = 10
        queryMap["page"] = 1

    }


}