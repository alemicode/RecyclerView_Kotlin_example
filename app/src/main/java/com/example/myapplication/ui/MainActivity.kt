package com.example.myapplication.ui

import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.DataSource
import com.example.myapplication.models.BlogPost
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var listItems: List<BlogPost>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listItems = DataSource.createDataSet()


        setRecyclerView()
    }

    private fun setRecyclerView() {
        recycler_view.apply {
            var recyclerItemAdapter = BlogRecyclerAdapter(listItems)
            recycler_view.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recycler_view.adapter = recyclerItemAdapter
        }
    }
}
