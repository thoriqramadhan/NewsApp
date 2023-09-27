package com.thoriqramadhan.newsapp.data.network

import android.provider.ContactsContract.DisplayNameSources
import com.thoriqramadhan.newsapp.data.NewsResponse
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    fun getCommonMuslimNews(
        @Query("q") keyWords: String = "islam",
        @Query("language") language: String = "en",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("pageSize") pageSize: Int = 30,
    ) : Call<NewsResponse>

    @GET("everything")
    fun getAboutAlQuranNews(
        @Query("q") keyWords: String = "islam",
        @Query("language") language: String = "en",
        ) : Call<NewsResponse>

    @GET("top-headline")
    fun getAlJazeeraNews(
        @Query("sources") sources: String = "al-jazeera-english"

    ): Call<NewsResponse>

    @GET("everything")
    fun getWarningForIslam(
        @Query("q") keyWords: String = "anti islam"
    ):Call<NewsResponse>
    @GET("everything")
    fun searchNews(
        @Query("q") query: String,
        @Query("pageSize") pageSize: Int = 50
    ): Call<NewsResponse>
}
