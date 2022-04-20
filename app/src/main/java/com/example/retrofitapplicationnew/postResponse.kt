package com.example.retrofitapplicationnew


import com.google.gson.annotations.SerializedName

class postResponse : ArrayList<postResponseItem>()

data class postResponseItem(
    @SerializedName("body")
    val body: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("user_id")
    val userId: Int? = null
)