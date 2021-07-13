package com.dicoding.newsapp.webview

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.newsapp.databinding.ActivityWebviewBinding

class WebviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebviewBinding


    companion object {
        const val EXTRA_NEWS = "extra_news"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun init() {
        val extras = intent.extras

        if (extras != null) {
            val url = extras.getString(EXTRA_NEWS)
            with(binding) {
                webViewNews.settings.javaScriptEnabled = true
                webViewNews.loadUrl(url.toString())
            }
        }
    }
}