package com.chanhypark.baseapparchitecture.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.data.model.User


class UserAdapter constructor() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var collections: List<User> = emptyList()
        set(value) {
            value.let {
                field = it
                notifyDataSetChanged()
            }
        }


    override fun getItemCount(): Int {
        return this.collections.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user, parent, false)
        )

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = collections[position]


    }


    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }


}
