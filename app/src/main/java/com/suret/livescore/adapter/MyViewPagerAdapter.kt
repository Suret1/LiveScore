package com.suret.livescore.adapter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.suret.livescore.model.TabMenuModel


class MyViewPagerAdapter(
    private val data: TabMenuModel, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    private val context: Context? = null

    override fun getCount(): Int {
        return data.fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return data.fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return data.title[position]
    }



}