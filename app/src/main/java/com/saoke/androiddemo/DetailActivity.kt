package com.saoke.androiddemo

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.saoke.androiddemo.databinding.ActivityDetailBinding

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
//        原本打算用序列化直接传递对象的，但是我手机的API版本太低不支持这种写法
//        val up = intent.getSerializableExtra("up", Up::class.java)
        val name = intent.getStringExtra("name")
        val avatarResourceId = intent.getIntExtra("avatarResourceId", 0)
        val fansNumber = intent.getIntExtra("fansNumber", 0)
        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        binding.name = name
        binding.fansNumber = fansNumber
//        不知道为什么对头像的resourceId赋值，无法显示图片，只好改用findViewById
//        binding.avatarResourceId = avatarResourceId
        val avatar = findViewById<ImageView>(R.id.avatar)
        avatar.setImageResource(avatarResourceId)

        val followButton = findViewById<Button>(R.id.followButton)
    }
}