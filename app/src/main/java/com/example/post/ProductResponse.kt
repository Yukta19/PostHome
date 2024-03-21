package com.example.post

import android.os.Parcel
import android.os.Parcelable

data class ProductResponse(
    val title: String,
    val price: Int,
    val description: String,
    val images: List<String>,
    val category: Category,
    val id: Int,
    val creationAt: String,
    val updatedAt: String


) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.readParcelable(Category::class.java.classLoader)!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(price)
        parcel.writeString(description)
        parcel.writeStringList(images)
        parcel.writeParcelable(category, flags)
        parcel.writeInt(id)
        parcel.writeString(creationAt)
        parcel.writeString(updatedAt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ProductResponse> {
        override fun createFromParcel(parcel: Parcel): ProductResponse {
            return ProductResponse(parcel)
        }

        override fun newArray(size: Int): Array<ProductResponse?> {
            return arrayOfNulls(size)
        }
    }
}
