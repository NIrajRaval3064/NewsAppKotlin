package com.androiddevs.mvvmnewsapp.ui.repository

import com.androiddevs.mvvmnewsapp.ui.api.RetrofitNetworkInstance
import com.androiddevs.mvvmnewsapp.ui.dp.ArticleDatabase
import com.androiddevs.mvvmnewsapp.ui.model.Article

class NewsRepository(val db:ArticleDatabase) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitNetworkInstance.api.getBreakingNews(countryCode, pageNumber)
    suspend fun searchNews(searQuery:String,pageNumber: Int)=
        RetrofitNetworkInstance.api.getSearchNews(searQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    fun getSavedNews() = db.getArticleDao().getAllArticles()
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

}