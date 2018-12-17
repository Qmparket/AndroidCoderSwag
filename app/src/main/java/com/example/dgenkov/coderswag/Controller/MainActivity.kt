package com.example.dgenkov.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.dgenkov.coderswag.Adapters.CategoryAdapter
import com.example.dgenkov.coderswag.Adapters.CategoryRecycleAdapter
import com.example.dgenkov.coderswag.Model.Category
import com.example.dgenkov.coderswag.R
import com.example.dgenkov.coderswag.Services.DataService
import com.example.dgenkov.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter = CategoryAdapter(this,DataService.categories)
        adapter = CategoryRecycleAdapter(this,DataService.categories) {category ->
            val productsIntent = Intent(this,ProductsActivity::class.java)
            productsIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productsIntent)
        }

        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)




    }
}
