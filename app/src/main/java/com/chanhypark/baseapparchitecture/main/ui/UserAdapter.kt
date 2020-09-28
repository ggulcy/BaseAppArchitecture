package com.chanhypark.baseapparchitecture.main.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.data.model.User
import kotlinx.android.synthetic.main.item_user.view.*


class UserAdapter constructor(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
        (holder as UserViewHolder).bindItem(data, context)
    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(data: User, context: Context) {
            Glide.with(context)
                .load(data.picture.large)
                .into(itemView.iv_picture)
            itemView.tv_email.text = data.email
        }
    }


}
