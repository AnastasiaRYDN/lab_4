package com.example.usersapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.usersapp.MyRecyclerView.MyViewHolder

class MyRecyclerView() : RecyclerView.Adapter<MyViewHolder>() {

    var onUserClickListener: OnUserClickListener? = null

    var myList: List<User> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(myView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myList[position]
        holder.myText.text = "${currentItem.name} ${currentItem.secondName}"
        holder.rootView.setOnLongClickListener {
            onUserClickListener?.onUserClick(currentItem)
            true
        }
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val myText: TextView = itemView.findViewById(R.id.text_view_name)
        val rootView: View = itemView.rootView
    }

    interface OnUserClickListener {
        fun onUserClick(user: User)
    }
}