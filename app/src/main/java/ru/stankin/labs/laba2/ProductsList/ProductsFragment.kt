package ru.stankin.labs.laba2.ProductsList

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.stankin.labs.laba2.R
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.RecyclerView
import ru.stankin.labs.laba2.ProductItem.DetailsActivity
import ru.stankin.labs.laba2.ProductItem.ProductItem
import ru.stankin.labs.laba2.ProductItem.products

class ProductsFragment : Fragment(R.layout.product_list) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list: RecyclerView = view.findViewById(R.id.list)
        val adapter = ProductsAdapter(products(), this::onProductItemClicked)
        list.adapter = adapter

    }

    private fun openSecondFragment(item : ProductItem) {
        setFragmentResult(REQUEST_FRAGMENT, bundleOf(
            TITLE to item.title,
            DESCRIPTION to item.description,
            VALUE to item.value,
            IN_STOCK to item.inStock,
            ID to item.id
        ))
    }
    companion object {
        const val REQUEST_FRAGMENT = "request"
        const val TITLE = "title"
        const val DESCRIPTION = "description"
        const val VALUE = "value"
        const val IN_STOCK = "in_stock"
        const val ID = "id"
        fun newInstance(): ProductsFragment {
            return ProductsFragment()
        }
    }

    private fun onProductItemClicked(item: ProductItem) {
        openSecondFragment(item)
    }
}