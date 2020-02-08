package com.jadwal.justiceapp.contracts.fragments

import com.jadwal.justiceapp.models.Product

interface MakananFragmentContract {
    interface View{
        fun attachToRecycler(product : List<Product>)
        fun isLoading(state : Boolean)
        fun toast(message : String)
    }

    interface Interactor{
        fun destroy()
        fun allProduct()
    }
}