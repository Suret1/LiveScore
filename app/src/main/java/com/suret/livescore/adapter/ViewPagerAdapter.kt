package com.suret.livescore.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.*
import com.suret.livescore.R
import com.suret.livescore.model.TabMenuModel


class ViewPagerAdapter(
    private val data: TabMenuModel,
    fm: FragmentManager,
    activity: FragmentActivity
) :
    FragmentStatePagerAdapter(fm) {
    private val context: Context? = activity
    private lateinit var layoutInflater: LayoutInflater
    private lateinit var customTabLayout: View

    override fun getCount(): Int {
        return data.fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return data.fragments[position]
    }


    fun getTabView(position: Int): View? {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        layoutInflater = LayoutInflater.from(context)
        customTabLayout = layoutInflater.inflate(R.layout.custom_tabs, null)
        val tv = customTabLayout.findViewById(R.id.text) as TextView
        customTabLayout.setBackgroundResource(R.drawable.selected_tab)
        tv.text = data.title[position]
        val img: ImageView = customTabLayout.findViewById(R.id.back) as ImageView
        img.setImageResource(data.image[position])
        return customTabLayout
    }

    fun selectedTab(position: Int): View? {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        customTabLayout.setBackgroundResource(R.drawable.selected_tab)
        val tv = customTabLayout.findViewById(R.id.text) as TextView
        tv.text = data.title[position]
        val img: ImageView = customTabLayout.findViewById(R.id.back) as ImageView
        img.setImageResource(data.image[position])
        return customTabLayout
    }
}