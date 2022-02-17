package com.system.fivertask.activity

import MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.system.fivertask.R
import com.system.fivertask.adapter.MainAdapter
import com.system.fivertask.databinding.ActivityMainBinding
import com.system.fivertask.model.FactModel
import com.tpltrakker.main.api.GeneralApiResponse
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    // val viewModel : MainViewModel by viewModels()


    companion object {
        lateinit var viewModel: MainViewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



       viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.add.setOnClickListener {
            getFacts();
        }


    }

    fun getFacts() {
        viewModel.getFacts(this);

        viewModel.getGetFactState.observe(this, Observer {
            when (it) {
                is GeneralApiResponse.Success<List<FactModel>> -> {

                    binding.recyclerview.adapter = MainAdapter(it.data!!)
                    binding.recyclerview.layoutManager = LinearLayoutManager(this)
                    binding.recyclerview.setHasFixedSize(true)


                }


            }

        })



    }
}

