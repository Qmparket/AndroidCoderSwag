package com.example.dgenkov.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.Toast
import com.example.dgenkov.coderswag.Adapters.ProductsAdapter
import com.example.dgenkov.coderswag.R
import com.example.dgenkov.coderswag.Services.DataService
import com.example.dgenkov.coderswag.Utilities.EXTRA_CATEGORY
import com.example.dgenkov.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var adapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        adapter = ProductsAdapter(this,DataService.getProducts(categoryType)) {product ->
            val itemIntent = Intent(this,ItemActivity::class.java)
            itemIntent.putExtra(EXTRA_PRODUCT,product)
            startActivity(itemIntent)
        }

        val orientation = resources.configuration.orientation

        var spanCount = 2
        val screenSize = resources.configuration.screenWidthDp

        if(screenSize > 720) {
            spanCount = 3
        }

        if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        val layoutManager = GridLayoutManager(this,spanCount)
        productListView.layoutManager = layoutManager
        productListView.adapter = adapter
    }
}
