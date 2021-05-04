package com.suret.livescore.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.suret.livescore.model.NewsModel

class NewsViewModel : ViewModel() {
    lateinit var db: FirebaseFirestore
    var newsList = MutableLiveData<List<NewsModel>>()


    fun getData() {
        db = FirebaseFirestore.getInstance()

        db.collection("news").get().addOnSuccessListener {
            val list = arrayListOf<NewsModel>()
            for (doc in it.documents) {
                val news = doc.toObject(NewsModel::class.java) ?: NewsModel()
                list.add(news)
            }
            newsList.value = list
        }
    }
}