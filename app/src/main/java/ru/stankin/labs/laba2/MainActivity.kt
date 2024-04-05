package ru.stankin.labs.laba2

import ru.stankin.labs.laba2.ProductsList.ProductsAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import ru.stankin.labs.laba2.ProductItem.DetailsActivity
import ru.stankin.labs.laba2.ProductItem.ProductItem
import ru.stankin.labs.laba2.ProductItem.products


class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val list: RecyclerView = findViewById(R.id.list)
        val adapter = ProductsAdapter(products(), this::onProductItemClicked)
        list.adapter = adapter
    }

    private fun onProductItemClicked(item: ProductItem) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("product_id", item.id)
        startActivity(intent)
    }
}