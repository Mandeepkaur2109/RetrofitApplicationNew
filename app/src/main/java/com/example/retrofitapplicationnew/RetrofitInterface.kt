package com.example.retrofitapplicationnew

import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    @GET("users")
    fun getUsers(): Call<UserResponse>

    @GET("users/{userId}")
    fun getSingleUser(@Path("userId") userId: Int): Call<UserResponseItem>

    @GET("comments")
    fun getComments(): Call<commentsResponse>

    @GET("comments/{commentsId}")
    fun getSingleComments(@Path("commentsId") commentsId: Int): Call<commentsResponseItem>

    @GET("posts")
    fun getPost(): Call<postResponse>

    @POST("users")
    @FormUrlEncoded
    fun createUser(@Header("Authorization") token: String,
                   @FieldMap() map:Map<String,String>

    ): Call<UserResponseItem>
}