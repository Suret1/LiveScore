package com.suret.livescore.ui.interest

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.suret.livescore.R
import com.suret.livescore.adapter.InterestRecyclerAdapter
import com.suret.livescore.listmaker.InterestListMaker
import com.suret.livescore.model.InterestModel
import kotlinx.android.synthetic.main.fragment_interest.*

class InterestFragment : Fragment(R.layout.fragment_interest) {
    private var interestList: MutableList<InterestModel> = arrayListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        interestList = InterestListMaker.interestListMaker()
        val interestAdapter = InterestRecyclerAdapter(interestList)

        interest_recycler.adapter = interestAdapter

        sign_in__btn_interest.setOnClickListener {
            Navigation.findNavController(requireActivity(),R.id.fragment_container).navigate(R.id.action_interestFragment_to_nestedFragment)

        }

    }
}