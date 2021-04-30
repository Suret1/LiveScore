package com.suret.livescore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.suret.livescore.R
import com.suret.livescore.model.TabMenuModel


class MyViewPagerAdapter(
    private val data: TabMenuModel,
    fm: FragmentManager,
    activity: FragmentActivity
) :
    FragmentStatePagerAdapter(fm) {
    private val context: Context = activity
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var customTabLayout: View

    override fun getCount(): Int {
        return data.fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return data.fragments[position]
    }

    fun setCustomLayout(position: Int, isSelected: Boolean): View {
        layoutInflater = LayoutInflater.from(context)
        customTabLayout = layoutInflater.inflate(R.layout.custom_tabs, null)
        val title: TextView = customTabLayout.findViewById(R.id.textTitle)
        val icon: ImageView = customTabLayout.findViewById(R.id.textIcon)
        icon.setImageResource(data.image[position])
        if (isSelected) {
            customTabLayout.setBackgroundResource(R.drawable.selected_tab)
            title.text = data.title[position]
        } else {
            customTabLayout.setBackgroundResource(R.drawable.disabled_tab)
            title.text = ""
        }
        return customTabLayout
    }
}