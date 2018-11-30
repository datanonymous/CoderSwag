package com.example.koeal.coderswag

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var adapter: CategoryRecycleAdapter //not necessary?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categoryListView.adapter = CategoryRecycleAdapter(this, DataService.categories){category ->
            Toast.makeText(this,"Category title is: ${category.title}",Toast.LENGTH_SHORT).show()
            val productIntent = Intent(this, ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        //needs context, needs view to serve to list view, and needs to know the data that it will be adapting
        //categoryListView.adapter = adapter

        //Layout manager positions item views inside a recyclerview and determines when to reuse items
        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

//        //this won't work for recycler views
////        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
////            val category = DataService.categories[i]
////            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
////        }

    }
}
