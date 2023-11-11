package com.saoke.androiddemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("MyLog","开始onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建数据
        DataSender.createData()
        val upListData = DataSender.getFollowedList()
        val activitiesList = DataSender.getActivitiesList()

        val upListView = findViewById<RecyclerView>(R.id.up_list)
        val upListAdapter = UpListAdapter()
        upListAdapter.setData(upListData)

        upListView.adapter = upListAdapter

        val activityViewpager = findViewById<ViewPager2>(R.id.activity_viewpager)
        val adapter = ActivityViewpagerAdapter()
        adapter.setData(activitiesList)
        Log.d("MyLog", upListData.toString())
        activityViewpager.adapter = adapter
        activityViewpager.currentItem = 0

        upListAdapter.setOnItemClickListener(object : UpListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // ViewPager2切换到对应页面
                activityViewpager.currentItem = position
            }
        })
        // 长按头像跳转Up主详细页面
        upListAdapter.setOnItemLongClickListener(object : UpListAdapter.OnItemLongClickListener {
            override fun onItemLongClick(up: Up): Boolean {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("name", up.name)
                intent.putExtra("avatarResourceId", up.avatarResourceId)
                intent.putExtra("fansNumber", up.fansNumber)
                startActivity(intent)
                return true
            }
        })
    }
}