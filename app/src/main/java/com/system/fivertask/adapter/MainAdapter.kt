package com.system.fivertask.adapter

import MainViewModel
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.system.fivertask.activity.Details
import com.system.fivertask.databinding.ViewMainBinding
import com.system.fivertask.model.FactModel





class MainAdapter(private val modelList: List<FactModel>) : RecyclerView.Adapter<MainAdapter.ListHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val itemBinding = ViewMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListHolder(itemBinding)


    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val listModel: FactModel = modelList[position]
        holder.bind(listModel,position)


    }

    override fun getItemCount(): Int = modelList.size

    class ListHolder(private val itemBinding: ViewMainBinding ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(listModel: FactModel,position: Int) {

           try {

               val arr: List<String> = listModel.text.split(" ")
               var nWords = ""
               for (i in 0 until 3) {
                   nWords = nWords + " " + arr[i]
               }

               itemBinding.text.text = nWords+"..."
               itemBinding.date.text = listModel.createdAt





           } catch (e:Exception){
               itemBinding.text.text =listModel.text+"..."

           }

            itemBinding.card.setOnClickListener(){
                val intent = Intent(itemView.context, Details::class.java)
                intent.putExtra("text", listModel.text)
                intent.putExtra("date", listModel.createdAt)
                intent.putExtra("position", position.toString())
                itemView.context.startActivity(intent)
            }


            }



        }}
