package com.saoke.androiddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

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
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.up_list_data, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])

        holder.itemView.setOnClickListener { itemClickListener?.onItemClick(position) }
        holder.itemView.setOnLongClickListener { itemLongClickListener?.onItemLongClick(data[position]) == true }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val upName: TextView = itemView.findViewById(R.id.up_name)
        private val upAvatar: ImageView = itemView.findViewById(R.id.up_avatar)

        fun bindData(data: Up) {
            upName.text = data.name
            upAvatar.setImageResource(data.avatarResourceId)
        }
    }

    fun deleteData(upName: String) {
        for (i in 0 until data.size) {
            if (data[i].name == upName) {
                data.removeAt(i)
                notifyItemRemoved(i)
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