package com.aniketjain.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.aniketjain.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), NewsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        set Binding View
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val items = fetchData()

//        setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val newsAdapter = NewsAdapter(items, this)
        binding.recyclerView.adapter = newsAdapter

    }

    private fun fetchData(): ArrayList<String> {
        val arrayList = ArrayList<String>()
        for (i in 0 until 100) {
            arrayList.add("Item $i")
        }
        return arrayList
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this, "Titled $item", Toast.LENGTH_SHORT).show()
    }

}