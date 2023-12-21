package com.saoke.androiddemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saoke.androiddemo.R
import com.saoke.androiddemo.databinding.ActivityViewpagerDataBinding
import com.saoke.androiddemo.logic.model.Activity

class ActivityViewpagerAdapter : RecyclerView.Adapter<ActivityViewpagerAdapter.MyViewHolder>() {

    private var data: MutableList<Activity> = mutableListOf()

    fun setData(data: MutableList<Activity>) {
        this.data = data
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            ActivityViewpagerDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    fun deleteData(upName: String) {
        for (i in 0 until data.size) {
            if (data[i].up.name == upName) {
                data.removeAt(i)
                notifyItemRemoved(i)
                break
            }
        }
    }

    class MyViewHolder(private val binding: ActivityViewpagerDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Activity) {
            binding.upView.text =
                binding.root.context.getString(R.string.viewpage_title, data.up.name)
            binding.textView.text = data.text
            binding.imageView.setImageResource(data.image)
        }
    }
}