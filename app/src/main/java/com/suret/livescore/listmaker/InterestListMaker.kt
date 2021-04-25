package com.suret.livescore.listmaker

import com.suret.livescore.R
import com.suret.livescore.model.InterestModel

class InterestListMaker {
    companion object {

        fun interestListMaker(): MutableList<InterestModel> {
            val interestList: MutableList<InterestModel> = arrayListOf()

            interestList.add(
                InterestModel(
                    R.drawable.soccer,
                    R.string.soccer
                )
            )
            interestList.add(
                InterestModel(
                    R.drawable.basketball,
                    R.string.basketball

                )
            )
            interestList.add(
                InterestModel(
                    R.drawable.football,
                    R.string.football
                )
            )
            interestList.add(
                InterestModel(
                    R.drawable.baseball,
                    R.string.baseball
                )
            )
            interestList.add(
                InterestModel(
                    R.drawable.tennis,
                    R.string.tennis
                )
            )
            interestList.add(
                InterestModel(
                    R.drawable.volleyball,
                    R.string.volleyball
                )
            )
            return interestList

        }

    }
}