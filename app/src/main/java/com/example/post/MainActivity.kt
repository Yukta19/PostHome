package com.example.post

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections


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

//    fun sendDataToServer() {
//
//        val title = findViewById<EditText>(R.id.titleEditText).text.toString()
//        val price = findViewById<EditText>(R.id.priceEditText).text.toString()
//        val description = findViewById<EditText>(R.id.descriptionEditText).text.toString()
//        val categoryId = findViewById<EditText>(R.id.categoryIdEditText).text.toString()
//        val imageUrl = findViewById<EditText>(R.id.imageUrlEditText).text.toString()
//
//        val productRequest = ProductRequest(title, price, Collections.singletonList("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb93E0nDzsfCBelNGOf04OlRg0gP_mRtirWg&usqp=CAU"), categoryId, imageUrl)
//        //val postId = "1"
//        //val call = ApiClient.apiService.postProduct()
//
//        GlobalScope.launch(Dispatchers.IO) {
//            val response = apiInterface.postProduct(productRequest)
//            if (response.isSuccessful) {
//                val productResponse = response.body()
//                productResponse?.let {
//                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
//                    intent.putExtra("productDetails", it)
//                    startActivity(intent)
//                }
//            } else {
//            }
//        }
//    }
fun sendDataToServer() {
    val title = findViewById<EditText>(R.id.titleEditText).text.toString()
    val price = findViewById<EditText>(R.id.priceEditText).text.toString()
    val description = findViewById<EditText>(R.id.descriptionEditText).text.toString()
    val categoryId = findViewById<EditText>(R.id.categoryIdEditText).text.toString()
    val imageUrl = findViewById<EditText>(R.id.imageUrlEditText).text.toString()

    val productRequest = ProductRequest(title, price, Collections.singletonList("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRb93E0nDzsfCBelNGOf04OlRg0gP_mRtirWg&usqp=CAU"), categoryId, imageUrl)

    // Assuming you have defined your API service as `apiService` in ApiClient
    val call = ApiClient.apiService.postProduct(productRequest)

    call.enqueue(object : Callback<ProductResponse> {


        override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
            if (response.isSuccessful) {
                val productResponse = response.body()
                Log.d("hello",productResponse.toString())
                productResponse?.let {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra("productDetails", it)
                    startActivity(intent)
                }
            } else {
                // Handle error
            }
        }

        override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
            Log.d("hello",t.message.toString())
        }
    })
}

}
