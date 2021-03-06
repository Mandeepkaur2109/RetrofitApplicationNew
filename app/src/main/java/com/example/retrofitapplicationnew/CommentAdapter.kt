package com.example.retrofitapplicationnew

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    var array = ArrayList<commentsResponseItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName = view.findViewById<TextView>(R.id.tvName)
        var tvEmail = view.findViewById<TextView>(R.id.tvEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_comment, parent, false)
        return ViewHolder(view.rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.setText(array[position].name)
        holder.tvEmail.setText(array[position].email)
    }

    override fun getItemCount(): Int {
        return array.size
    }

    fun updateList(array: ArrayList<commentsResponseItem>){
        this.array.addAll(array)
        notifyDataSetChanged()
    }

    fun clearList(){
        this.array.clear()
        notifyDataSetChanged()
    }
}