package ru.stankin.labs.laba2.ProductItem

data class ProductItem (
    val title: String,
    val description: String,
    val value: Int,
    val inStock: Boolean,
)

fun products() : List<ProductItem> = MutableList(20) { index ->
    ProductItem(
        title = "Product $index",
        description = "cute product $index",
        value = index * 100,
        inStock = index % 2 == 0
    )
}