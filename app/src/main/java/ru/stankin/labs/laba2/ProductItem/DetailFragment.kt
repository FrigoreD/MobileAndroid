package ru.stankin.labs.laba2.ProductItem

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import ru.stankin.labs.laba2.R

class DetailFragment : Fragment(R.layout.product_detail) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = requireArguments().getString(TITLE)
        val description = requireArguments().getString(DESCRIPTION)
        val value = requireArguments().getString(VALUE)
        val inStock = requireArguments().getString(IN_STOCK)
        val id = requireArguments().getString(ID)
        val button = requireArguments().getString(BUTTON)

        val titleView: TextView = view.findViewById(R.id.product_title)
        val descriptionView: TextView = view.findViewById(R.id.product_description)
        val valueView: TextView = view.findViewById(R.id.product_value)
        val inStockView: TextView = view.findViewById(R.id.product_in_stock)
        val idView: TextView = view.findViewById(R.id.product_id)
        val buttonView: Button = view.findViewById(R.id.button)

        buttonView.setOnClickListener { onBrowseClick() }

        titleView.text = title
        descriptionView.text = description
        valueView.text = value
        inStockView.text = inStock
        idView.text = id
        buttonView.text = button
    }
    companion object {
        private const val TITLE = "title"
        private const val DESCRIPTION = "description"
        private const val VALUE = "value"
        private const val IN_STOCK = "in_stock"
        private const val ID = "id"
        private const val BUTTON = "BUTTON"

        fun newInstance(
            title: String,
            description: String,
            value: Int,
            inStock: Boolean,
            id: Int,

        ): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(
                    TITLE to title,
                    DESCRIPTION to description,
                    VALUE to "Value: $value",
                    IN_STOCK to "In stock: ${if (inStock) "Yes" else "No"}",
                    ID to "ID: $id",
                    BUTTON to "Button: $id"
                )
            }
        }
    }

    private fun onBrowseClick() {
        val url = "http://www.google.com"
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}