package ru.stankin.labs.laba2.ProductsList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.stankin.labs.laba2.ProductItem.ProductItem
import ru.stankin.labs.laba2.R

class ProductsAdapter(
    private val products: List<ProductItem>,
    private val onItemClicked: (item: ProductItem) -> Unit,
): RecyclerView.Adapter<ProductViewHolder>() {

    private fun onViewHolderClicked(position: Int) {
        onItemClicked(products[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view, this::onViewHolderClicked)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder, position: Int
    ) {
        holder.bind(products[position])
    }
}