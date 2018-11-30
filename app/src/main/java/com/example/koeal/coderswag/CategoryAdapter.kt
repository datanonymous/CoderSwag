package com.example.koeal.coderswag

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CategoryAdapter(context: Context, categories:List<Category>):BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View

        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null) //category_list_item is the pattern to be repeated (needs category image and category name to populate)

        //setting up variables
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImage)
        val categoryName:TextView = categoryView.findViewById(R.id.categoryName)

        val category = categories[position]

        categoryImage.setImageResource(context.resources.getIdentifier(category.image, "drawable",context.packageName))
        categoryName.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count() //this will return the number of rows to be displayed
    }



}