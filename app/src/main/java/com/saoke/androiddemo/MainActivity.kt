package com.saoke.androiddemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import com.saoke.androiddemo.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private val upListAdapter = UpListAdapter()
    private val viewpagerAdapter = ActivityViewpagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 创建数据
        DataSender.createData()

        // 关注的Up主和对应的动态
        val upListData = DataSender.followedList
        val activitiesList = DataSender.getActivitiesList()

        val upListView = binding.upList     // Up主RecyclerView
        upListAdapter.setData(upListData)
        upListView.adapter = upListAdapter

        val activityViewpager = binding.activityViewpager
        viewpagerAdapter.setData(activitiesList)
        activityViewpager.adapter = viewpagerAdapter
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
                startActivity.launch(intent)
                return true
            }
        })
    }

    private val startActivity = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // 处理返回的结果
        val code = result.resultCode // 返回码 如：Activity.RESULT_OK、Activity.RESULT_CANCELED
        val data = result.data

        if (code == RESULT_OK && data != null) {
            val upName = data.getStringExtra("upName")
            if (upName != null) {
                upListAdapter.deleteData(upName)
                viewpagerAdapter.deleteData(upName)
            }
        }
    }
}