package com.saoke.androiddemo.logic.model

import java.io.Serializable

// 数据类（DataClass）自动生成 equals()、hashCode()、toString() 以及 copy() 方法
data class Up(var name: String, var avatarResourceId: Int, var fansNumber: Int) : Serializable {
    lateinit var activity: Activity
}