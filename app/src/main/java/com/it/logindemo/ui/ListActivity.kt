package com.it.logindemo.ui

import MainAdapter
import ListRepository
import RetrofitService
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.it.logindemo.data.viewmodel.ListViewModel
import com.it.logindemo.data.viewmodel.MyViewModelFactory
import com.it.logindemo.databinding.ActivityListBinding
import com.it.logindemo.utils.Utilility

class ListActivity : AppCompatActivity() {
    private val TAG = "ListActivity"
    private lateinit var binding: ActivityListBinding

    lateinit var viewModel: ListViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get viewmodel instance using ViewModelProvider.Factory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(ListRepository(retrofitService))).get(
                ListViewModel::class.java
            )
        //set adapter in recyclerview
        binding.recyclerview.adapter = adapter

        Handler().postDelayed(Runnable {
            if (Utilility.isNetworkAvailable(this)) {
                showProgressBar()
                viewModel.getAllData()
                binding.recyclerview.visibility = View.VISIBLE

            } else {
                stopProgressBar()
                Toast.makeText(this, "NETWORK NOT AVAILABLE", Toast.LENGTH_LONG).show()
            }

        }, 50)

        //the observer will only receive events if the owner(activity) is in active state
        //invoked when dataList data changes
        viewModel.dataList.observe(this, Observer {
            stopProgressBar()
            if (it != null) {
                Log.d(TAG, "dataList: $it")
                adapter.setMovieList(it)
            } else {
                Toast.makeText(this, "Error in fetching data", Toast.LENGTH_SHORT).show()
            }
        })

        //invoked when a network exception occurred
        stopProgressBar()
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun stopProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onDestroy() {
        // don't send events once the activity is destroyed

        if(Utilility.isNetworkAvailable(this))
        viewModel.disposable.dispose()
        super.onDestroy()
    }
}