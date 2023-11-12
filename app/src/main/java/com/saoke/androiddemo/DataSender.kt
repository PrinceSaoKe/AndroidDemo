package com.saoke.androiddemo

object DataSender {
    private val upListData = mutableListOf<Up>()
    private val activitiesList = mutableListOf<Activity>()
    private val followedList = mutableListOf<Up>()

    fun createData() {
        createUp()
        createActivities()
        initFollowedList()
    }

    fun getActivitiesList(): MutableList<Activity> {
        val list = mutableListOf<Activity>()
        followedList.forEach { up -> list.add(up.activity) }
        return list
    }

    fun getFollowedList(): MutableList<Up> {
        return followedList
    }

    private fun createUp(): MutableList<Up> {
        upListData.add(Up("骚客.", R.drawable.saoke))
        upListData.add(Up("娜娜", R.drawable.nana))
        upListData.add(Up("小橘", R.drawable.xiaoju))
        upListData.add(Up("包公", R.drawable.baogong))
        upListData.add(Up("布偶", R.drawable.buou))
        upListData.add(Up("丸子", R.drawable.wanzi))
        return upListData
    }

    private fun createActivities(): MutableList<Activity> {
        activitiesList.add(Activity(upListData[0], "好想...好想成为原生高手！", R.drawable.saoke))
        activitiesList.add(
            Activity(
                upListData[1],
                "娜娜的表情包（印堂发黑猫，鼻子掉漆猫）",
                R.drawable.nana
            )
        )
        activitiesList.add(Activity(upListData[2], "我将以高达形态出击", R.drawable.xiaoju))
        activitiesList.add(Activity(upListData[3], "你的脸好黑，就叫你包公吧！", R.drawable.baogong))
        activitiesList.add(Activity(upListData[4], "这是布偶的动态", R.drawable.buou))
        activitiesList.add(Activity(upListData[5], "这是丸子的动态", R.drawable.wanzi))

        // 将Up和动态绑定
        for (index in upListData.indices) {
            upListData[index].activity = activitiesList[index]
        }

        return activitiesList
    }

    private fun initFollowedList() {
        followedList.addAll(upListData)
    }

    fun unfollow(upName: String) {
        for (i in 0 until followedList.size) {
            if (followedList[i].name == upName) {
                followedList.removeAt(i)
                break
            }
        }
    }

    fun follow(upName: String) {
        var up = upListData[0]
        for (i in 0 until upListData.size) {
            if (upListData[i].name == upName) {
                up = upListData[i]
                break
            }
        }
        if (!followedList.contains(up)) {
            followedList.add(up)
        }
    }
}