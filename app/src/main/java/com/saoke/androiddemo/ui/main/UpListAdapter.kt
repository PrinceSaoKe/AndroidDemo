package com.saoke.androiddemo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saoke.androiddemo.databinding.UpListDataBinding
import com.saoke.androiddemo.logic.model.Up

class UpListAdapter : RecyclerView.Adapter<UpListAdapter.MyViewHolder>() {

    private var data: MutableList<Up> = mutableListOf()

    private var itemClickListener: OnItemClickListener? = null
    private var itemLongClickListener: OnItemLongClickListener? = null

    fun setData(data: MutableList<Up>) {
        this.data = data
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = UpListDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.itemView.setOnClickListener { itemClickListener?.onItemClick(position) }
        holder.itemView.setOnLongClickListener { itemLongClickListener?.onItemLongClick(data[position]) == true }
    }

    class MyViewHolder(private val binding: UpListDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Up) {
            binding.upName.text = data.name
            binding.upAvatar.setImageResource(data.avatarResourceId)
        }
    }

    fun deleteData(upName: String) {
        for (i in 0 until data.size) {
            if (data[i].name == upName) {
                data.removeAt(i)
                notifyItemRemoved(i)
                notifyItemRangeChanged(0, data.size)
                break
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(up: Up): Boolean
    }

    fun setOnItemLongClickListener(listener: OnItemLongClickListener) {
        itemLongClickListener = listener
    }

}