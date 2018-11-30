package com.example.koeal.coderswag

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CategoryRecycleAdapter(val context: Context, val categories:List<Category>): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //inflate view for first time if does not already exist
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.category_list_item,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //access specific category for a particular position
        holder?.bindCategory(categories[position],context)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //alt-enter add constructor parameters
        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category:Category, context:Context){
            val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
        }
    }

}