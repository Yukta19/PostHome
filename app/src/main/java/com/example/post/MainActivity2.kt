package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val productDetails = intent.getParcelableExtra<ProductResponse>("productDetails")
        productDetails?.let {
            val titleTextView=findViewById<TextView>(R.id.titleTextView)
            titleTextView.text = "Title: ${it.title}"
            val priceTextView = findViewById<TextView>(R.id.productIdTextView)
            priceTextView.text = "Price: ${it.price}"
            val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)
            descriptionTextView.text = "Description: ${it.description}"
            val categoryIdTextView = findViewById<TextView>(R.id.categoryIdTextView)
            categoryIdTextView.text = "Category ID: ${it.category.id}"
            val categoryNameTextView = findViewById<TextView>(R.id.categoryNameTextView)
            categoryNameTextView.text = "Category Name: ${it.category.name}"
            val categoryImageView = findViewById<TextView>(R.id.categoryImageView)
            categoryImageView.text = "Category Image: ${it.category.image}"
            val categoryCreationAtTextView = findViewById<TextView>(R.id.categoryCreationAtTextView)
            categoryCreationAtTextView.text = "Category Creation Date: ${it.category.creationAt}"
            val categoryUpdatedAtTextView = findViewById<TextView>(R.id.categoryUpdatedAtTextView)
            categoryUpdatedAtTextView.text = "Category Updated Date: ${it.category.updatedAt}"
            val productIdTextView = findViewById<TextView>(R.id.productIdTextView)
            productIdTextView.text = "Product ID: ${it.id}"
            val creationAtTextView = findViewById<TextView>(R.id.creationAtTextView)
            creationAtTextView.text = "Creation Date: ${it.creationAt}"
            val updatedAtTextView = findViewById<TextView>(R.id.updatedAtTextView)
            updatedAtTextView.text = "Updated Date: ${it.updatedAt}"
            val imageUrlTextView = findViewById<TextView>(R.id.imageUrlTextView)
            imageUrlTextView.text = "Image URL: ${it.images.joinToString()}"
        }
    }
}