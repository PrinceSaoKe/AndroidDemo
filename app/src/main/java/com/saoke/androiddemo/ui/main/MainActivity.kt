package com.saoke.androiddemo.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager2.widget.ViewPager2
import com.saoke.androiddemo.databinding.ActivityMainBinding
import com.saoke.androiddemo.logic.model.DataSender
import com.saoke.androiddemo.logic.model.Up
import com.saoke.androiddemo.ui.detail.DetailActivity


class MainActivity : ComponentActivity() {
    private val recyclerviewAdapter = UpListAdapter()
    private val viewpagerAdapter = ActivityViewpagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)   // activity_main.xml
        setContentView(binding.root)

        // 创建数据
        DataSender.createData()

        // 关注的Up主和对应的动态
        val upListData = DataSender.followedList
        val activitiesList = DataSender.getActivitiesList()

        recyclerviewAdapter.setData(upListData)
        binding.upList.adapter = recyclerviewAdapter

        val activityViewpager = binding.activityViewpager
        viewpagerAdapter.setData(activitiesList)
        activityViewpager.adapter = viewpagerAdapter
        activityViewpager.currentItem = 0

        recyclerviewAdapter.setOnItemClickListener(object : UpListAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                // ViewPager2切换到对应页面
                activityViewpager.currentItem = position
            }
        })
        // 长按头像跳转Up主详细页面
        recyclerviewAdapter.setOnItemLongClickListener(object :
            UpListAdapter.OnItemLongClickListener {
            override fun onItemLongClick(up: Up): Boolean {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
//                intent.putExtra("up", up)
                intent.putExtra("name", up.name)
                intent.putExtra("fansNumber", up.fansNumber)
                intent.putExtra("avatarResourceId", up.avatarResourceId)
                startActivity.launch(intent)
                return true
            }
        })

        // 当ViewPager2滑到一个动态页面时RecyclerView也选中相应元素
        binding.activityViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.upList.scrollToPosition(position)
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
                recyclerviewAdapter.deleteData(upName)
                viewpagerAdapter.deleteData(upName)
            }
        }
    }
}