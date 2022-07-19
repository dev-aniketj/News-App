package com.aniketjain.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.aniketjain.newsapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), NewsItemClicked {

    private lateinit var mAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        set Binding View
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fetchData()

//        setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter = NewsAdapter(this)
        binding.recyclerView.adapter = mAdapter

    }

    private fun fetchData() {
        val url =
            "https://newsapi.org/v2/top-headlines?country=in&apiKey=5d6cf8ff391548db8027b34b58785a9a"
// Request a JSON response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                val newsJSONArray = response.getJSONArray("articles")
                val newsArray = ArrayList<NewsModel>()
                for(i in 0 until newsJSONArray.length()) {
                    val newsJsonObject = newsJSONArray.getJSONObject(i)
                    val news = NewsModel(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                    newsArray.add(news)
                }
                mAdapter.updateNews(newsArray)
            },
            {
                Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show()
            }
        )
        // Add the request to the RequestQueue.
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item: NewsModel) {
        Toast.makeText(this, "Titled ${item.title}", Toast.LENGTH_SHORT).show()
    }

}