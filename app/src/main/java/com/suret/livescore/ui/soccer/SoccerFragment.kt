package com.suret.livescore.ui.soccer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.suret.livescore.MainActivity
import com.suret.livescore.R
import com.suret.livescore.adapter.NewsRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_soccer.*

class SoccerFragment : Fragment(R.layout.fragment_soccer) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val map = mapOf<Any, Any>(
//            "news_title" to "UEFA CHAMPIONS LEAGUE",
//            "news_date" to "1 may 2021 16:01",
//            "news_thumbnail" to "news.jpg"
//        )


        (activity as MainActivity).newsViewModel.newsList.observe(viewLifecycleOwner) { newsList ->
            newsList?.let {
                val adapter = NewsRecyclerAdapter(it)
                news_recycler.adapter = adapter
            }
        }

    }


}