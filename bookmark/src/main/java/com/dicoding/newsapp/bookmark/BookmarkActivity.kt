package com.dicoding.newsapp.bookmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dicoding.newsapp.bookmark.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookmarkBinding

    private var newsAdapter: NewsAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)
    }
}