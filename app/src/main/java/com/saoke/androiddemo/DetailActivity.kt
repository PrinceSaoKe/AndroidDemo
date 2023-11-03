package com.saoke.androiddemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.saoke.androiddemo.databinding.ActivityDetailBinding

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
//        原本打算用序列化传递对象的，但是我手机的API版本太低
//        val up = intent.getSerializableExtra("up", Up::class.java)
        val name = intent.getStringExtra("name")
        val avatarResourceId = intent.getIntExtra("avatarResourceId", 0)
        val fansNumber = intent.getIntExtra("fansNumber", 0)
        val binding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.name = name
        binding.avatarResourceId = avatarResourceId
        binding.fansNumber = fansNumber
    }
}