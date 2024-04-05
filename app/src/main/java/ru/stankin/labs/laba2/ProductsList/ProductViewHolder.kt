package ru.stankin.labs.laba2.ProductsList

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.stankin.labs.laba2.ProductItem.ProductItem
import ru.stankin.labs.laba2.R

class ProductViewHolder(
    itemView: View,
    private val onItemClicked: (position: Int) -> Unit
): RecyclerView.ViewHolder(itemView) {
    private val titleView: TextView =
        itemView.findViewById(R.id.product_title)
    private val descriptionView: TextView =
        itemView.findViewById(R.id.product_description)
    private val valueView: TextView =
        itemView.findViewById(R.id.product_value)
    private val inStockView: TextView =
        itemView.findViewById(R.id.product_in_stock)

    init {
        itemView.setOnClickListener {onItemClicked(absoluteAdapterPosition)}
    }

            fun bind(item: ProductItem) {
                titleView.text = item.title
                descriptionView.text =
                    "Description: ${item.description}"
                valueView.text =
                    "Value: ${item.value}"
                inStockView.text =
                    "In stock: ${if (item.inStock) "Yes" else "No"}"
            }
}