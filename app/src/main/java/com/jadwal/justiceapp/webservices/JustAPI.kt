package com.jadwal.justiceapp.webservices

import com.google.gson.annotations.SerializedName
import com.jadwal.justiceapp.models.Product
import com.jadwal.justiceapp.utilities.JusticeUtils
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

class JustAPI {
    companion object {
        private var retrofit: Retrofit? = null
        private var okHttpClient = OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build()

        private fun getClient() : Retrofit{
           return if (retrofit == null){
               retrofit = Retrofit.Builder().baseUrl(JusticeUtils.API_ENDPOINT).client(okHttpClient)
                   .addConverterFactory(GsonConverterFactory.create()).build()
               retrofit!!
           }else{
               retrofit!!
           }
        }

        fun instance(): JusticeAPIService = getClient().create(JusticeAPIService::class.java)
    }
}

interface JusticeAPIService{
    @GET("api/product/category/2")
    fun product() : Call<WrappedListResponse<Product>>
}

data class WrappedResponse<T>(
    @SerializedName("message") var message : String?,
    @SerializedName("status") var status : String?,
    @SerializedName("data") var data : T?
){
    constructor(): this(null, null, null )
}

data class WrappedListResponse<T>(
    @SerializedName("message") var message: String?,
    @SerializedName("status") var status: Boolean?,
    @SerializedName("data") var data: List<T>?
){
    constructor(): this(null, null, null )
}

