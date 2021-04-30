package com.suret.livescore.nested.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.suret.livescore.R
import com.suret.livescore.adapter.MyViewPagerAdapter
import com.suret.livescore.model.TabMenuModel
import com.suret.livescore.ui.baseball.BaseballFragment
import com.suret.livescore.ui.basketball.BasketballFragment
import com.suret.livescore.ui.football.FootballFragment
import com.suret.livescore.ui.soccer.SoccerFragment
import com.suret.livescore.ui.tennis.TennisFragment
import com.suret.livescore.ui.volleyball.VolleyballFragment


class ExploreFragment : Fragment(R.layout.fragment_explore) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager: ViewPager = view.findViewById(R.id.explore_viewpager)
        val tabLayout: TabLayout = view.findViewById(R.id.explore_tablayout)
        val listOfFragments: ArrayList<Fragment> = arrayListOf()

        listOfFragments.add(SoccerFragment())
        listOfFragments.add(BasketballFragment())
        listOfFragments.add(FootballFragment())
        listOfFragments.add(BaseballFragment())
        listOfFragments.add(TennisFragment())
        listOfFragments.add(VolleyballFragment())

        val listOfTitles: ArrayList<String> = arrayListOf()

        listOfTitles.add(view.resources.getString(R.string.soccer))
        listOfTitles.add(view.resources.getString(R.string.basketball))
        listOfTitles.add(view.resources.getString(R.string.football))
        listOfTitles.add(view.resources.getString(R.string.baseball))
        listOfTitles.add(view.resources.getString(R.string.tennis))
        listOfTitles.add(view.resources.getString(R.string.volleyball))

        val listOfImage: ArrayList<Int> = arrayListOf()

        listOfImage.add(R.drawable.soccer)
        listOfImage.add(R.drawable.basketball)
        listOfImage.add(R.drawable.football)
        listOfImage.add(R.drawable.baseball)
        listOfImage.add(R.drawable.tennis)
        listOfImage.add(R.drawable.volleyball)


        val menuModel = TabMenuModel(listOfFragments, listOfImage, listOfTitles)

        val myViewPagerAdapter = MyViewPagerAdapter(
            menuModel,
            requireActivity().supportFragmentManager, requireActivity()
        )
        viewPager.adapter = myViewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            if (i == 0) {
                tab?.customView = (myViewPagerAdapter.setCustomLayout(i, true))
            } else {
                tab?.customView = (myViewPagerAdapter.setCustomLayout(i, false))
            }
        }
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val text = tab?.customView?.findViewById<TextView>(R.id.textTitle)
                tab?.customView?.setBackgroundResource(R.drawable.selected_tab)
                when (tab?.position) {
                    0 -> {
                        text?.text = view.resources.getString(R.string.soccer)
                    }
                    1 -> {
                        text?.text = view.resources.getString(R.string.basketball)
                    }
                    2 -> {
                        text?.text = view.resources.getString(R.string.football)
                    }
                    3 -> {
                        text?.text = view.resources.getString(R.string.baseball)
                    }
                    4 -> {
                        text?.text = view.resources.getString(R.string.tennis)
                    }
                    5 -> {
                        text?.text = view.resources.getString(R.string.volleyball)
                    }
                }

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val text = tab?.customView?.findViewById<TextView>(R.id.textTitle)
                tab?.customView?.setBackgroundResource(R.drawable.disabled_tab)
                text?.text = ""
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                //
            }
        })
    }
}