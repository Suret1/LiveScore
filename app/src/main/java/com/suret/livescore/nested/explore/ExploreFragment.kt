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
import com.suret.livescore.adapter.ViewPagerAdapter
import com.suret.livescore.model.TabMenuModel
import com.suret.livescore.ui.baseball.BaseballFragment
import com.suret.livescore.ui.basketball.BasketballFragment
import com.suret.livescore.ui.football.FootballFragment
import com.suret.livescore.ui.soccer.SoccerFragment
import com.suret.livescore.ui.tennis.TennisFragment
import com.suret.livescore.ui.volleyball.VolleyballFragment
import kotlinx.android.synthetic.main.fragment_explore.*


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

        val myViewPagerAdapter = ViewPagerAdapter(
            menuModel,
            requireActivity().supportFragmentManager, requireActivity()
        )
        viewPager.adapter = myViewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            tab?.customView = (myViewPagerAdapter.getTabView(i))
        }



        val shape = LayoutInflater.from(context).inflate(R.layout.custom_tabs, null) as LinearLayout
        val image = shape.findViewById<ImageView>(R.id.back)
        val textView = shape.findViewById<TextView>(R.id.text)

        val disableLayout =
            LayoutInflater.from(context).inflate(R.layout.disable_tab, null) as LinearLayout
        val iconDisable = disableLayout.findViewById<ImageView>(R.id.back)

//
//        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_soccer_icon)
//        tabLayout.getTabAt(1)?.setIcon(R.drawable.basketball)
//        tabLayout.getTabAt(2)?.setIcon(R.drawable.football)
//        tabLayout.getTabAt(3)?.setIcon(R.drawable.baseball)
//        tabLayout.getTabAt(4)?.setIcon(R.drawable.tennis)
//        tabLayout.getTabAt(5)?.setIcon(R.drawable.volleyball)


//        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                //
//            }
//
//            override fun onPageSelected(position: Int) {
//                val tab = tabLayout.getTabAt(position)
//                tab?.customView = myViewPagerAdapter.selectedTab(position)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//                //
//            }
//
//        })

//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                when (tab?.position) {
//                        0-> {
//                        image.setImageResource(R.drawable.soccer)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Soccer"
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                    1 -> {
//                        image.setImageResource(R.drawable.basketball)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Basketball "
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                    2 -> {
//                        image.setImageResource(R.drawable.baseball)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Baseball "
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                    3 -> {
//                        image.setImageResource(R.drawable.tennis)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Tennis "
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                    4 -> {
//                        image.setImageResource(R.drawable.football)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Football "
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                    5 -> {
//                        image.setImageResource(R.drawable.volleyball)
//                        shape.setBackgroundResource(R.drawable.selected_tab)
//                        textView.text = "Volleyball "
//                        textView.visibility = View.VISIBLE
//                        tab?.customView = shape
//                    }
//                }
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                when (tab?.position) {
//                    0 -> {
//                        iconDisable.setImageResource(R.drawable.soccer)
//                        tab?.customView = disableLayout
//                    }
//                    1 -> {
//                        iconDisable.setImageResource(R.drawable.basketball)
//                        tab?.customView = disableLayout
//                    }
//                    2 -> {
//                        iconDisable.setImageResource(R.drawable.baseball)
//                        tab?.customView = disableLayout
//                    }
//                    3 -> {
//                        iconDisable.setImageResource(R.drawable.tennis)
//                        tab?.customView = disableLayout
//                    }
//                    4 -> {
//                        iconDisable.setImageResource(R.drawable.football)
//                        tab?.customView = disableLayout
//                    }
//                    5 -> {
//                        iconDisable.setImageResource(R.drawable.volleyball)
//                        tab?.customView = disableLayout
//                    }
//                }
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                //
//            }
//
//        })

    }


}