package com.example.dgenkov.coderswag.Adapters

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.dgenkov.coderswag.Model.Category
import com.example.dgenkov.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*
import org.w3c.dom.Text

class CategoryRecycleAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.category_list_item, parent,false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindCategory(categories[position], context)
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView?.findViewById<ImageView>(R.id.categoryImage)
        var categoryName = itemView?.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context) {
            var resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title

        }
    }

}