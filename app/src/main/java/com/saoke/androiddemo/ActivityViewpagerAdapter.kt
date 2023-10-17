package com.saoke.androiddemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityViewpagerAdapter : RecyclerView.Adapter<ActivityViewpagerAdapter.MyViewHolder>() {

    private var data: MutableList<Activity> = mutableListOf()

    fun setData(data: MutableList<Activity>) {
        this.data = data
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_viewpager_data, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val upView: TextView = itemView.findViewById(R.id.activity_up)
        private val textView: TextView = itemView.findViewById(R.id.activity_text)
        private val imageView: ImageView = itemView.findViewById(R.id.activity_image)

        fun bindData(data: Activity) {
            upView.text = data.up.name + "的动态"
            textView.text = data.text
            imageView.setImageResource(data.image)
        }
    }
}