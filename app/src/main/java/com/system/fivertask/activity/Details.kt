package com.system.fivertask.activity

import MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.system.fivertask.R
import com.system.fivertask.activity.MainActivity.Companion.viewModel
import com.system.fivertask.adapter.MainAdapter
import com.system.fivertask.databinding.ActivityDetailsBinding
import com.system.fivertask.databinding.ActivityMainBinding
import com.system.fivertask.model.FactModel
import com.tpltrakker.main.api.GeneralApiResponse
import dagger.hilt.android.AndroidEntryPoint


class Details : AppCompatActivity() {


    private lateinit var binding: ActivityDetailsBinding
   // lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
     //   viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val ss: String = intent.getStringExtra("text").toString()
        val date: String = intent.getStringExtra("date").toString()
        val position: String = intent.getStringExtra("position").toString()

        binding.text.setText(ss)
        binding.date.setText(date)

        binding.delete.setOnClickListener() {
            viewModel.remove(position.toInt())


            Toast.makeText(this, "Delete Successfully", Toast.LENGTH_LONG).show()

            finish();
        }


    }



}
