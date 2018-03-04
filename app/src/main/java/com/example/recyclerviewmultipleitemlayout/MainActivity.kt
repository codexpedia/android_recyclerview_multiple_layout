package com.example.recyclerviewmultipleitemlayout

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

import java.util.ArrayList

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing list view with the custom adapter
        val itemList = ArrayList<Item>()

        val itemArrayAdapter = ItemArrayAdapter(itemList)
        item_list.layoutManager = LinearLayoutManager(this)
        item_list.itemAnimator = DefaultItemAnimator()
        item_list.adapter = itemArrayAdapter

        // Populating list items
        for (i in 0..99) {
            if (i % 2 == 0) {
                itemList.add(Item("Item " + i, ItemType.ONE_ITEM))
            } else {
                itemList.add(Item("Item " + i, ItemType.TWO_ITEM))
            }
        }
    }
}
