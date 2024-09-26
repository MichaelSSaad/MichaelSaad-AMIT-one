
package com.example.hiltexample.viewmodel

import androidx.lifecycle.*
import com.example.hiltexample.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _data = MutableLiveData<List<DataModel>>()
    val data: LiveData<List<DataModel>> get() = _data

    fun loadData() {
        viewModelScope.launch {
            try {
                val result = repository.fetchData()
                _data.postValue(result)
            } catch (e: Exception) {
                // handle error
            }
        }
    }
}
