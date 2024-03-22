package com.example.post

import android.os.Parcel
import android.os.Parcelable

data class ProductRequest(
    val categoryId: String,
    val description: String,
    val images: List<String>,
    val price: String,
    val title: String
)