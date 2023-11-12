package com.saoke.androiddemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2


class MainActivity : ComponentActivity() {
    private val upListAdapter = UpListAdapter()
    private val adapter = ActivityViewpagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 创建数据
        DataSender.createData()
    }

    override fun onResume() {
        super.onResume()

        val upListData = DataSender.getFollowedList()
        val activitiesList = DataSender.getActivitiesList()

        val upListView = findViewById<RecyclerView>(R.id.up_list)
        upListAdapter.setData(upListData)

        upListView.adapter = upListAdapter

        val activityViewpager = findViewById<ViewPager2>(R.id.activity_viewpager)
        adapter.setData(activitiesList)
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
                startActivityForResult(intent, 1)
                return true
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (data != null) {
                    val upName = data.getStringExtra("upName")
                    if (upName != null) {
                        upListAdapter.deleteData(upName)
                        adapter.deleteData(upName)
                    }
                }
            }
        }
    }
}