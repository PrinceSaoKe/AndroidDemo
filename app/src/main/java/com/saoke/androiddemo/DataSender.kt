package com.saoke.androiddemo

class DataSender {
    private val upListData = mutableListOf<Up>()
    private val activitiesList = mutableListOf<Activity>()

    fun createData() {
        createUp()
        createActivities()
    }

    fun getUpList(): MutableList<Up> {
        return upListData
    }

    fun getActivitiesList(): MutableList<Activity> {
        return activitiesList
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
        activitiesList.add(Activity(upListData[1], "娜娜的表情包（印堂发黑猫，鼻子掉漆猫）",R.drawable.nana))
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
}