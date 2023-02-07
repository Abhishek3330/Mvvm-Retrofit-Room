package test.com.mvvmretrofitroom.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import test.com.mvvmretrofitroom.repository.QuoteRepository

/**
 * Created by Mukesh on 17-01-2023.
 */
class MainViewModelFactory(private val repository: QuoteRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }


}