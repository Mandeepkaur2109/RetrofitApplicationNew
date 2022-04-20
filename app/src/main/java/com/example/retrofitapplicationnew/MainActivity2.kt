package com.example.retrofitapplicationnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity() {
    lateinit var retrofit: retrofit
    lateinit var commentsAdapter: CommentAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        recyclerView = findViewById(R.id.rv)
        progressBar = findViewById(R.id.progressBar)
        retrofit = retrofit()
        commentsAdapter = CommentAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = commentsAdapter

    }

    fun getComments(view: View) {
        progressBar.visibility = View.VISIBLE
        commentsAdapter.clearList()
        retrofit.retrofitInterface.getComments().enqueue(object : Callback<commentsResponse> {
            override fun onResponse(call: Call<commentsResponse>, response: Response<commentsResponse>) {
                Log.e("TAG", "response ${response.body()}")
                response.body()?.let { commentsAdapter.updateList(it) }
                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<commentsResponse>, t: Throwable) {
                Log.e("TAG", "response ${t}")
                Toast.makeText(this@MainActivity2, t.toString(), Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        })
    }

    fun getSingleComments(view: View) {
        progressBar.visibility = View.VISIBLE
        commentsAdapter.clearList()
        retrofit.retrofitInterface.getSingleComments(100).enqueue(object : Callback<commentsResponseItem> {
            override fun onResponse(
                call: Call<commentsResponseItem>,
                response: Response<commentsResponseItem>
            ) {
                Log.e("TAG", "response ${response.body()}")
                response.body()?.let {
                    var arrayList = ArrayList<commentsResponseItem>()
                    arrayList.add(it)
                    commentsAdapter.updateList(arrayList)
                }
                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<commentsResponseItem>, t: Throwable) {
                Log.e("TAG", "response ${t}")
                Toast.makeText(this@MainActivity2, t.toString(), Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        })
    }
}