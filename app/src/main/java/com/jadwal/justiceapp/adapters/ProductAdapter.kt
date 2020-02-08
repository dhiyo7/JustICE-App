package com.jadwal.justiceapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.jadwal.justiceapp.R
import com.jadwal.justiceapp.models.Product
import com.jadwal.justiceapp.utilities.JusticeUtils
import kotlinx.android.synthetic.main.adapter_makanan.view.*

class ProductAdapter (var product: List<Product>, var context: Context) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.adapter_makanan, parent, false))

    override fun getItemCount() = product.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(product[position], context)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder (itemView){
        fun bind (product : Product, context: Context){
            itemView.nameProduct.text = product.name
            itemView.namePrice.text = product.price.toString()
            itemView.imageProduct.load("${JusticeUtils.API_ENDPOINT}/images/${product.image}"){
                transformations(RoundedCornersTransformation(15.0F))
            }
            itemView.setOnClickListener{
                Toast.makeText(context, "Kuwuk " + product.id, Toast.LENGTH_SHORT).show()
            }
        }

    }

}