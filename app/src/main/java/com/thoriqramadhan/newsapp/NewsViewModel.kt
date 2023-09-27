package com.thoriqramadhan.newsapp

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.thoriqramadhan.newsapp.data.NewsResponse
import com.thoriqramadhan.newsapp.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class NewsViewModel : ViewModel(){
//    Expose screen UI State
    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>

    private var _aboutAlQuran = MutableLiveData<NewsResponse>()
    val aboutalQuran get() = _aboutAlQuran as LiveData<NewsResponse>

    private var _alJazeera = MutableLiveData<NewsResponse>()
    val alJazeera get() = _alJazeera as LiveData<NewsResponse>

    private var _warningMuslimNews = MutableLiveData<NewsResponse>()
    val warningMuslimNews get() = _warningMuslimNews as LiveData<NewsResponse>

    private var _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

//    Handle business logic
    fun getCommonMuslimNews(){
    ApiClient.getApiService().getCommonMuslimNews().enqueue(object : Callback<NewsResponse> {
        override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
            if(response.isSuccessful){
                Log.i("ViewModel","onResponse: ${response.body()}")
                _commonMuslimNews.postValue(response.body())
            }else Log.e("ViewModel",
                "onFailedCall: Call error with Http Status Code : " + response.code())

        }

        override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
            Log.e("ViewModel","onFailure: " + t.localizedMessage)
        }

    })
    }
    fun searchNews(query:String){
        ApiClient.getApiService().searchNews(query).enqueue(object : Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful){
                    _searchNews.value = response.body()
                    _searchNews.postValue(response.body())
                }else Log.e("NewsViewModel", "onResponse: ${response.message()}", )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsViewModel", "onFailure: ${t.localizedMessage}", )
            }
        })

    }
}
