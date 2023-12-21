package com.saoke.androiddemo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import com.saoke.androiddemo.databinding.ActivityDetailBinding

class DetailActivity : ComponentActivity() {
    private var followAction = true
    private var name: String = ""
    private var fansNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        fansNumber = intent.getIntExtra("fansNumber", 0)
        if (savedInstanceState != null) {
            followAction = savedInstanceState.getBoolean("followAction")
            fansNumber = savedInstanceState.getInt("fansNumber")
        }
        val intent = intent
//        原本打算用序列化直接传递对象的，但是好像我手机的API版本太低不支持这种写法？
//        val up = intent.getSerializableExtra("up", Up::class.java)
        name = intent.getStringExtra("name")!!
        val avatarResourceId = intent.getIntExtra("avatarResourceId", 0)
        super.onCreate(savedInstanceState)
//        val binding: ActivityDetailBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val myBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(myBinding.root)
        myBinding.followButton.text = if (followAction) "取消关注" else "关注"

        myBinding.name = name
        myBinding.fansNumber.text = getString(R.string.fans_number, fansNumber.toString())
//        不知道为什么dataBinding对头像的resourceId赋值，无法显示图片，只好改用viewBinding
//        binding.avatarResourceId = avatarResourceId
        myBinding.avatar.setImageResource(avatarResourceId)

        myBinding.followButton.setOnClickListener {
            if (followAction) {
                Toast.makeText(this, "已取消关注", Toast.LENGTH_SHORT).show()
                fansNumber--
            } else {
                Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show()
                fansNumber++
            }
            followAction = !followAction
            recreate()
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (!followAction) {
                    val backIntent = Intent()
                    backIntent.putExtra("upName", name)
                    setResult(RESULT_OK, backIntent)
                }
                finish()
            }
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("followAction", followAction)
        outState.putInt("fansNumber", fansNumber)
    }
}