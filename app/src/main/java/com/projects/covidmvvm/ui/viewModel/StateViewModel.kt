package com.projects.covidmvvm.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projects.covidmvvm.data.models.StateWiseModel
import com.projects.covidmvvm.data.repos.Covid19Repository
import kotlinx.coroutines.*

class StateViewModel: ViewModel() {

    var liveData : MutableLiveData<StateWiseModel> = MutableLiveData()
    fun fetchdata() {
        viewModelScope.launch{
            val statewiseResponse = withContext(Dispatchers.IO){ Covid19Repository.getStateWiseData() }
            liveData.postValue(statewiseResponse)
        }
    }
}

/**extension function for handling network call coroutines in [viewmodel] scope
fun ViewModel.runIO(dispatcher: CoroutineDispatcher = Dispatchers.IO,
                    function: suspend CoroutineScope.() -> Unit){
    viewModelScope.launch(dispatcher) {
        function
    }
}
        **/