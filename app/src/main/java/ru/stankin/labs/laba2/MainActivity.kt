package ru.stankin.labs.laba2

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.stankin.labs.laba2.ProductItem.DetailFragment
import ru.stankin.labs.laba2.ProductsList.ProductsFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_host, ProductsFragment.newInstance(), null)
            .commit()

        supportFragmentManager.setFragmentResultListener(
            ProductsFragment.REQUEST_FRAGMENT, this, ::onProductsFragmentResult
        )
    }
    private fun isLandscapeMode() : Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }
    private fun onProductsFragmentResult(requestKey: String, data: Bundle) {
        val title =
            data.getString(ProductsFragment.TITLE) ?:
            throw IllegalArgumentException("TODO")
        val description =
            data.getString(ProductsFragment.DESCRIPTION) ?:
            throw IllegalArgumentException("TODO")
        val value =
            data.getInt(ProductsFragment.VALUE)
        val inStock =
            data.getBoolean(ProductsFragment.IN_STOCK)
        val id =
            data.getInt(ProductsFragment.ID)

        val isLandscape = isLandscapeMode()

        supportFragmentManager.beginTransaction()
            .replace(
                if (isLandscape) R.id.fragment_details  else R.id.fragment_host,
                DetailFragment.newInstance(
                title = title,
                description = description,
                value = value,
                inStock = inStock,
                id = id,
            ), null)
            .apply {
                if (!isLandscape) {
                    addToBackStack("DetailFragment")
                }
            }
            .commit()
    }
}