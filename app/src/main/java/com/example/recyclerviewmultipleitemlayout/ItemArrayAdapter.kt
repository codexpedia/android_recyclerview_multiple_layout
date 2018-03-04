package com.example.recyclerviewmultipleitemlayout

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import java.util.ArrayList

class ItemArrayAdapter(private val itemList: ArrayList<Item> = ArrayList()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // get the size of the list
    override fun getItemCount(): Int = itemList.size

    // determine which layout to use for the row
    override fun getItemViewType(position: Int): Int {
        val item = itemList!![position]
        return if (item.type == ItemType.ONE_ITEM) {
            TYPE_ONE
        } else if (item.type == ItemType.TWO_ITEM) {
            TYPE_TWO
        } else {
            -1
        }
    }


    // specify the row layout file and click for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ONE) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_type1, parent, false)
            return ViewHolderOne(view)
        } else if (viewType == TYPE_TWO) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_type2, parent, false)
            return ViewHolderTwo(view)
        } else {
            throw RuntimeException("The type has to be ONE or TWO")
        }
    }

    // load data in each row element
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, listPosition: Int) {
        when (holder.itemViewType) {
            TYPE_ONE -> initLayoutOne(holder as ViewHolderOne, listPosition)
            TYPE_TWO -> initLayoutTwo(holder as ViewHolderTwo, listPosition)
            else -> {
            }
        }
    }

    private fun initLayoutOne(holder: ViewHolderOne, pos: Int) {
        holder.item.text = itemList!![pos].name
    }

    private fun initLayoutTwo(holder: ViewHolderTwo, pos: Int) {
        holder.tvLeft.text = itemList!![pos].name
        holder.tvRight.text = itemList[pos].name
    }


    // Static inner class to initialize the views of rows
    internal class ViewHolderOne(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item: TextView

        init {
            item = itemView.findViewById(R.id.row_item) as TextView
        }
    }

    inner class ViewHolderTwo(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvLeft: TextView
        var tvRight: TextView

        init {
            tvLeft = itemView.findViewById(R.id.row_item_left) as TextView
            tvRight = itemView.findViewById(R.id.row_item_right) as TextView
        }
    }

    companion object {
        private val TYPE_ONE = 1
        private val TYPE_TWO = 2
    }
}
