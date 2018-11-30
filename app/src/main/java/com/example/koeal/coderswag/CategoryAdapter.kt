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

        val holder: ViewHolder

        if(convertView == null){
            println("I exist for the first time!")
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null) //category_list_item is the pattern to be repeated (needs category image and category name to populate)

            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage)
            holder.categoryName = categoryView.findViewById(R.id.categoryName)

            categoryView.tag = holder //setting a unique value to the categoryView
        } else {
            println("Recycling view...")
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]

        //setting category image
        holder.categoryImage?.setImageResource(context.resources.getIdentifier(category.image, "drawable",context.packageName))
        //setting category name
        holder.categoryName?.text = category.title

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

    private class ViewHolder{
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null
    }

}