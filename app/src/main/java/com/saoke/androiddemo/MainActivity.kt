package com.saoke.androiddemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建数据
        val dataSender = DataSender()
        dataSender.createData()
        val upListData = dataSender.getUpList()
        val activitiesList = dataSender.getActivitiesList()

        val upListView = findViewById<RecyclerView>(R.id.up_list)
        val upListAdapter = UpListAdapter()
        upListAdapter.setData(upListData)

        upListView.adapter = upListAdapter

        val activityViewpager = findViewById<ViewPager2>(R.id.activity_viewpager)
        val adapter = ActivityViewpagerAdapter()
        adapter.setData(activitiesList)
        activityViewpager.adapter = adapter
        activityViewpager.currentItem = 0

        upListAdapter.setOnItemClickListener(object : UpListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // ViewPager2切换到对应页面
                activityViewpager.currentItem = position
                println("666666666666666")
            }
        })
    }
}