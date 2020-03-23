package com.rk.kotlinsamples

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(context: Context, users: Array<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private val mUsers = users
    private val mcontext = context
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.textview.text = mUsers[position]
        holder.itemView.setOnClickListener {
            showToast(mcontext, mUsers.get(position))
        }
    }

    override fun getItemCount(): Int {
        return mUsers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(
            LayoutInflater.from(mcontext).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textview = itemView.textView
    }
}