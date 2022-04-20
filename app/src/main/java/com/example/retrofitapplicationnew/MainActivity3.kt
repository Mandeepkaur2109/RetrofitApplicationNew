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

class MainActivity3 : AppCompatActivity() {
    lateinit var retrofit: retrofit
    lateinit var postAdapter: PostAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        recyclerView = findViewById(R.id.rv)
        progressBar = findViewById(R.id.progressBar)
        retrofit = retrofit()
        postAdapter = PostAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = postAdapter

    }

    fun getPost(view: View) {
        progressBar.visibility = View.VISIBLE
        postAdapter.clearList()
        retrofit.retrofitInterface.getPost().enqueue(object : Callback<postResponse> {
            override fun onResponse(call: Call<postResponse>, response: Response<postResponse>) {
                Log.e("TAG", "response ${response.body()}")
                response.body()?.let { postAdapter.updateList(it) }
                progressBar.visibility = View.GONE

            }

            override fun onFailure(call: Call<postResponse>, t: Throwable) {
                Log.e("TAG", "response ${t}")
                Toast.makeText(this@MainActivity3, t.toString(), Toast.LENGTH_LONG).show()
                progressBar.visibility = View.GONE
            }
        })
    }


}