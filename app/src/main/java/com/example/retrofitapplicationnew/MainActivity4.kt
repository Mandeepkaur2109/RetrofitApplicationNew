package com.example.retrofitapplicationnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity4 : AppCompatActivity() {
    lateinit var retrofit: retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        retrofit = retrofit()
    }



    fun CreateUser(view: View) {
        retrofit.retrofitInterface.createUser(
            "Bearer 3ee949f72c6f36c0d90a9cb2b4cbcb91176626fcbf387a2daa2894750686de9e",
            mapOf("email" to "gillmandeep@gmail.com" , "name" to "mandeep" , "gender" to "female" , "status" to "active"))
            .enqueue(
            object  : Callback<UserResponseItem> {
                override fun onResponse(
                    call: Call<UserResponseItem>,
                    response: Response<UserResponseItem>
                ) {
                    Log.e("TAG", " in success")
                    Toast.makeText(this@MainActivity4, " User created successfully", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UserResponseItem>, t: Throwable) {
                    Toast.makeText(this@MainActivity4, "in error ${t.toString()}", Toast.LENGTH_LONG).show()
                    Log.e("TAG", " in error")

                }
            }
        )
    }
}