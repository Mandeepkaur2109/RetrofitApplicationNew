package com.example.retrofitapplicationnew


import com.google.gson.annotations.SerializedName

class commentsResponse : ArrayList<commentsResponseItem>()

data class commentsResponseItem(
    @SerializedName("body")
    val body: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("post_id")
    val postId: Int? = null
)