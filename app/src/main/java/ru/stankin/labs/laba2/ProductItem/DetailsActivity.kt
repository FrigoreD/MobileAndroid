package ru.stankin.labs.laba2.ProductItem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.stankin.labs.laba2.R

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productIdIntent = intent.getIntExtra("product_id", -1)
        if (productIdIntent == -1) {
            throw IllegalArgumentException("No 'productId' parameter passed")
        }

        setContentView(R.layout.product_detail)

        val productTitle: TextView = findViewById(R.id.product_title)
        val productDescription: TextView = findViewById(R.id.product_description)
        val productValue: TextView = findViewById(R.id.product_value)
        val productInStock: TextView = findViewById(R.id.product_in_stock)
        val productId: TextView = findViewById(R.id.product_id)
        val button: TextView = findViewById(R.id.button)

        val productItem: ProductItem = productGetById(productIdIntent)

        productTitle.append(productItem.title)
        productDescription.append("Description: ${productItem.description}")
        productValue.append("Value: ${productItem.value}")
        productInStock.append("In stock: ${if (productItem.inStock) "Yes" else "No"}")
        productId.append("ID: ${productItem.id}")
        button.append("Button: ${productItem.id}")

        button.setOnClickListener { onBrowseClick() }
    }

    private fun onBrowseClick() {
        val url = "http://www.google.com"
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

}