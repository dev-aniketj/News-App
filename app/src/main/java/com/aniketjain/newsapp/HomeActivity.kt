package com.aniketjain.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aniketjain.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        set Binding View
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val items = fetchData()
        val adapter = NewsAdapter(items)
        binding.recyclerView.adapter = adapter

    }

    private fun fetchData(): ArrayList<String> {
        val arrayList: ArrayList<String> = ArrayList()

        for (i in 0 until 100) {
            arrayList.add("Item $i")
        }
        return arrayList
    }

}