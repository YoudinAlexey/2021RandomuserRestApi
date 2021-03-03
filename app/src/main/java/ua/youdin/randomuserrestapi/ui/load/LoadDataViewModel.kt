package ua.youdin.randomuserrestapi.ui.load

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import ua.youdin.randomuserrestapi.data.RandomUserRepository
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data

class LoadDataViewModel(private val repository: RandomUserRepository) : ViewModel() {
    var currentPosition: Int = 0
    private var currentResult: Flow<PagingData<Data>>? = null
    fun loadData(): Flow<PagingData<Data>> =
        repository.loadResult().cachedIn(viewModelScope)

    fun onClick(view: View, data: Data, position: Int) {
        currentPosition = position
        val action = LoadDataDirections.actionLoadDataToDetail(data)
        view.findNavController().navigate(action)
    }
}