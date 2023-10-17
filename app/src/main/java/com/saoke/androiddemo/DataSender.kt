package com.saoke.androiddemo

class DataSender {
    private val upListData = mutableListOf<Up>()
    private val activitiesList = mutableListOf<Activity>()

    public fun createData() {
        createUp()
        createActivities()
    }

    public fun getUpList(): MutableList<Up> {
        return upListData
    }

    public fun getActivitiesList(): MutableList<Activity> {
        return activitiesList
    }

    private fun createUp(): MutableList<Up> {
        upListData.add(Up("骚客.", 6, R.drawable.saoke))
        upListData.add(Up("娜娜", 10, R.drawable.nana))
        upListData.add(Up("小橘", 5, R.drawable.xiaoju))
        upListData.add(Up("包公", 3, R.drawable.baogong))
        upListData.add(Up("布偶", 3, R.drawable.buou))
        upListData.add(Up("丸子", 3, R.drawable.wanzi))
        return upListData
    }

    private fun createActivities(): MutableList<Activity> {
        activitiesList.add(Activity(upListData[0], "骚客.的Android笔记", R.drawable.saoke))
        activitiesList.add(Activity(upListData[1], "娜娜的表情包", R.drawable.nana))
        activitiesList.add(Activity(upListData[2], "这是小橘的动态", R.drawable.xiaoju))
        activitiesList.add(Activity(upListData[3], "这是包公的动态", R.drawable.baogong))
        activitiesList.add(Activity(upListData[4], "这是布偶的动态", R.drawable.buou))
        activitiesList.add(Activity(upListData[4], "这是丸子的动态", R.drawable.wanzi))

        // 将Up和动态绑定
        for (index in upListData.indices) {
            upListData[index].activity = activitiesList[index]
        }

        return activitiesList
    }
}