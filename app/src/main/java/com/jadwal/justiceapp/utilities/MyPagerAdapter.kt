package com.jadwal.justiceapp.utilities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jadwal.justiceapp.fragments.MakananFragments

class MyPagerAdapter (fm : FragmentManager) : FragmentPagerAdapter(fm){
    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> {
                MakananFragments()
            }
            1-> {
                MakananFragments()
            }
            else-> {
                return MakananFragments()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0-> "Pertama"
            1-> "Kedua"
            else-> {
                return "Ketiga"
            }
        }
    }

}