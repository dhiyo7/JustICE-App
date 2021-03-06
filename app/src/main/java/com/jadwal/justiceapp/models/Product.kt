package com.jadwal.justiceapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product (
    @SerializedName("id") var id : Int?,
    @SerializedName("name") var name : String?,
    @SerializedName("category") var category : String?,
    @SerializedName("price") var price : Int?,
    @SerializedName("image") var image : String?,
    @SerializedName("description") var description : String?

)
    :Parcelable
{
    constructor() : this(null, null, null, null, null, null)
}