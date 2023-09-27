package com.thoriqramadhan.newsapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.thoriqramadhan.newsapp.fragments.AboutAlQuranFragment
import com.thoriqramadhan.newsapp.fragments.AlJazeeraFragment
import com.thoriqramadhan.newsapp.fragments.CommonFragment
import com.thoriqramadhan.newsapp.fragments.WarningFragment

class SectionPageAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {
//    getItemCount set mount of fragment which will be display in adapter
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
//        set arrange of fragment position in fragment activity
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> CommonFragment()

        }
    }
}