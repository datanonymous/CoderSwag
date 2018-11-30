package com.example.koeal.coderswag

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter:ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataService.getProducts(categoryType))

        //if phone is turned to landscape span count is 3 (3 columns)
        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        //large tablet screens have three columns
        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter

    }
}
