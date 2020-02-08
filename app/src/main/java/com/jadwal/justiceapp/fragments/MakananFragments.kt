package com.jadwal.justiceapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jadwal.justiceapp.R
import com.jadwal.justiceapp.adapters.ProductAdapter
import com.jadwal.justiceapp.contracts.fragments.MakananFragmentContract
import com.jadwal.justiceapp.models.Product
import com.jadwal.justiceapp.presenters.fragments.MakananFragmentPresenter
import kotlinx.android.synthetic.main.fragment_makanan.view.*

class MakananFragments : Fragment(), MakananFragmentContract.View{
    private var presenter = MakananFragmentPresenter (this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = inflater.inflate(
        R.layout.fragment_makanan, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.allProduct()
    }

    override fun attachToRecycler(product: List<Product>) {
        view!!.rvMakanan.apply {
            layoutManager = GridLayoutManager(activity, 2)
//            GridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
            adapter = ProductAdapter(product, activity!!)
        }
    }

    override fun isLoading(state: Boolean) {if(state)view!!.loading.visibility = View.VISIBLE else view!!.loading.visibility = View.GONE }

    override fun toast(message: String) = Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()

    override fun onDestroy() {
        super.onDestroy()
        presenter.destroy()
    }
}