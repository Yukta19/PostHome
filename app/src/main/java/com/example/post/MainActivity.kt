package com.example.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var apiInterface: ApiInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            sendDataToServer()
        }
    }
    private fun sendDataToServer() {

        val title = findViewById<EditText>(R.id.titleEditText).text.toString().toInt()
        val price = findViewById<EditText>(R.id.priceEditText).text.toString()
        val description = findViewById<EditText>(R.id.descriptionEditText).text.toString()
        val categoryId = findViewById<EditText>(R.id.categoryIdEditText).text.toString()
        val imageUrl = findViewById<EditText>(R.id.imageUrlEditText).text.toString().toInt()
//        val imageUrlString = findViewById<EditText>(R.id.imageUrlEditText).text.toString().toInt()
//        val imageUrl = imageUrlString.toIntOrNull() ?: 0
        val productRequest = Category(title, price, description, categoryId, imageUrl)

        GlobalScope.launch(Dispatchers.IO) {
            val response = apiInterface.postProduct(productRequest)
            if (response.isSuccessful) {
                val productResponse = response.body()
                productResponse?.let {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("productDetails", productResponse)
                    startActivity(intent)
                }
            } else {

            }
        }
    }
}