package com.saoke.androiddemo

object DataSender {
    private val upListData = mutableListOf<Up>()            // 所有的Up主
    private val activitiesList = mutableListOf<Activity>()  // 所有的动态
    val followedList = mutableListOf<Up>()                  // 我关注的Up主

    fun createData() {
        createUp()
        createActivities()
        initFollowedList()
    }

    private fun createUp(): MutableList<Up> {
        upListData.add(Up("骚客.", R.drawable.saoke, 123))
        upListData.add(Up("娜娜", R.drawable.nana, 1024))
        upListData.add(Up("小橘", R.drawable.xiaoju, 100))
        upListData.add(Up("包公", R.drawable.baogong, 25))
        upListData.add(Up("布偶", R.drawable.buou, 120))
        upListData.add(Up("丸子", R.drawable.wanzi, 15))
        return upListData
    }

    private fun createActivities(): MutableList<Activity> {
        activitiesList.add(Activity(upListData[0], "好想...好想成为原生高手！", R.drawable.saoke))
        activitiesList.add(
            Activity(
                upListData[1],
                "印堂发黑猫，鼻子掉漆猫",
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

    // 获取所有已关注的Up主的动态
    fun getActivitiesList(): MutableList<Activity> {
        val list = mutableListOf<Activity>()
        followedList.forEach { up -> list.add(up.activity) }
        return list
    }
}