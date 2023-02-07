package test.com.mvvmretrofitroom.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import test.com.mvvmretrofitroom.models.QuoteListItem
import test.com.mvvmretrofitroom.repository.QuoteRepository

/**
 * Created by Mukesh on 17-01-2023.
 */
class MainViewModel(private val repository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes()
        }
    }
    val quotesList : LiveData<List<QuoteListItem>>
    get() = repository.Quotes
}