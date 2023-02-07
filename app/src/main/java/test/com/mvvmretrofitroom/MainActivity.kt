package test.com.mvvmretrofitroom

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import test.com.mvvmretrofitroom.api.QuotesService
import test.com.mvvmretrofitroom.api.RetrofitHelper
import test.com.mvvmretrofitroom.quoteapplication.QuoteApplication
import test.com.mvvmretrofitroom.recyclerview.Adapter
import test.com.mvvmretrofitroom.repository.QuoteRepository
import test.com.mvvmretrofitroom.viewmodels.MainViewModel
import test.com.mvvmretrofitroom.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerview)
      val repository = (application as QuoteApplication).quoteRepository

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotesList.observe(this, Observer {
            this.recyclerview.layoutManager = LinearLayoutManager(this)
            val adapter = Adapter(it)
            recyclerview.adapter = adapter

        })


    }
}