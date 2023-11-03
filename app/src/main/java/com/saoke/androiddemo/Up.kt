package com.saoke.androiddemo

import android.view.View

class Up(var name: String, var avatarResourceId: Int) {
    lateinit var activity: Activity
    var fansNumber: Int = 0

    fun follow(view: View) {}
}