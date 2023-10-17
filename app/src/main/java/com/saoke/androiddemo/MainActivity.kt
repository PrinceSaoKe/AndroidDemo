package com.saoke.androiddemo

import android.os.Bundle
import android.view.View.OnTouchListener
import android.widget.ArrayAdapter
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.saoke.androiddemo.ui.theme.AndroidDemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            AndroidDemoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
//        }
        setContentView(R.layout.activity_main)

        // 创建数据
        val dataSender = DataSender()
        dataSender.createData()
        val upListData = dataSender.getUpList()
        val activitiesList = dataSender.getActivitiesList()

        val upListView = findViewById<RecyclerView>(R.id.up_list)
        upListView.adapter = UpListAdapter(this, upListData)

        val activityViewpager = findViewById<ViewPager2>(R.id.activity_viewpager)
        val adapter = ActivityViewpagerAdapter()
        adapter.setData(activitiesList)
        activityViewpager.adapter = adapter
        activityViewpager.currentItem = 0

//        frameLayout.addView(avatar);

//        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout);
//        linearLayout.layoutParams = LinearLayout.LayoutParams(
//            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
//            10F
//        );

        // 要显示的数据
        val title = arrayOf("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期天")
        val description =
            arrayOf(
                "周一周一，奄奄一息",
                "周二周二，肚子好饿",
                "周三周三，带病上班",
                "周四周四，重见天日",
                "周五周五，敲锣打鼓",
                "周六周六，大鱼大肉",
                "周日周日，死期将至"
            )

        val datas = mutableListOf<Map<String, String>>()

        for (i in title.indices) {
            val map = hashMapOf("title" to title[i], "description" to description[i])
            datas.add(map)
        }

        val myAdapter = SimpleAdapter(
            this,
            datas,
            R.layout.list_item,
            arrayOf<String>("title", "description"),
            intArrayOf(R.id.list_item_title, R.id.list_item_description)
        )

//        val listView = findViewById<ListView>(R.id.listview)
//
//        listView.adapter = myAdapter


//        // 创建 ArrayAdapter
//        // 构造函数的参数，第一个是上下文对象，第二个是列表项的模板，第三个就是数组
//        val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, title)
//
//        // 获取 ListView 对象
//        // 通过调用 setAdapter() 方法为 ListView 设置 Adapter 设置适配器
//        val listview = findViewById(R.id.listview) as ListView
//        listview.adapter = adapter

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
//        val recyclerAdapter = MyAdapter(this, description.toMutableList());
//        recyclerView.adapter = recyclerAdapter
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidDemoTheme {
        Greeting("Android")
    }
}