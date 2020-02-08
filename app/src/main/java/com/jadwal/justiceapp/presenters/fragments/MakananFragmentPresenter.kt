package com.jadwal.justiceapp.presenters.fragments

import com.jadwal.justiceapp.contracts.fragments.MakananFragmentContract
import com.jadwal.justiceapp.models.Product
import com.jadwal.justiceapp.webservices.JustAPI
import com.jadwal.justiceapp.webservices.WrappedListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MakananFragmentPresenter(private var view : MakananFragmentContract.View? ) : MakananFragmentContract.Interactor {
    private var api = JustAPI.instance()

    override fun allProduct() {
        view?.isLoading(true)
        api.product().enqueue(object  : Callback<WrappedListResponse<Product>>{
            override fun onFailure(call: Call<WrappedListResponse<Product>>, t: Throwable) {
                view?.isLoading(false)
                view?.toast(t.message.toString())
            }

            override fun onResponse(call: Call<WrappedListResponse<Product>>, response: Response<WrappedListResponse<Product>>) {
                if (response.isSuccessful){
                    view?.toast("wew")
                    val data = response.body() as WrappedListResponse<Product>
                    view?.toast("wew")
                    data.data?.let {
                        view?.attachToRecycler(it)

                    }
                }else{
                    view?.toast("Something went wrong")
                }
                view?.isLoading(false)
            }

        })
    }

    override fun destroy() { view == null }


}