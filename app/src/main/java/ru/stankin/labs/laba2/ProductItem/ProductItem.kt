package ru.stankin.labs.laba2.ProductItem

data class ProductItem (
    val id: Int,
    val title: String,
    val description: String,
    val value: Int,
    val inStock: Boolean,
)

fun products() : List<ProductItem> = MutableList(20) { index ->
    ProductItem(
        id = index,
        title = "Product $index",
        description = "cute product $index",
        value = index * 100,
        inStock = index % 2 == 0
    )
}

fun productGetById(id: Int): ProductItem {
    return ProductItem(
        id = id,
        title = "Product $id",
        description = "cute product $id",
        value = id * 100,
        inStock = id % 2 == 0
    )
}
