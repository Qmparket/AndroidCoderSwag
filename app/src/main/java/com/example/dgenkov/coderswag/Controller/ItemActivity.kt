package com.example.dgenkov.coderswag.Controller

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.dgenkov.coderswag.Model.Product
import com.example.dgenkov.coderswag.R
import com.example.dgenkov.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_item.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resourceId = resources.getIdentifier(product.image, "drawable",this.packageName)

        itemImage.setImageResource(resourceId)
        itemTitle.text = product.title
        itemPrice.text = product.price

        orderButton.setOnClickListener {
            val toast = Toast.makeText(this,"${product.title} added to cart",Toast.LENGTH_SHORT)
            //toast.view.setBackgroundColor(Color.TRANSPARENT)
            val text = toast.view.findViewById<TextView>(android.R.id.message)
            //text.setTextColor(Color.WHITE)
            text.textSize = (18f)
            toast.show()
        }
    }
}
