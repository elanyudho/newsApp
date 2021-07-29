package com.dicoding.newsapp.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.domain.model.News
import com.dicoding.newsapp.databinding.ActivityDetailBinding
import com.dicoding.newsapp.webview.WebviewActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_HEADLINE = "extra_headline"
    }

    private var binding: ActivityDetailBinding? = null

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val data = intent.getParcelableExtra<News>(EXTRA_HEADLINE)

        showDetailHeadline(data)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showDetailHeadline(detailNews: News?) {
        detailNews?.let {
            binding?.titleDetailNews?.text = detailNews.title
            binding?.authorDetailNews?.text = detailNews.author
            binding?.publishedAtDetailNews?.text = detailNews.publishedAt
            binding?.description?.text = detailNews.description
            binding?.imageNewsDetail?.let { it1 ->
                Glide.with(this)
                    .load(detailNews.urlToImage)
                    .into(it1)
            }

            binding?.buttonDetail?.setOnClickListener {
                val intent = Intent(this@DetailActivity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding?.iconBookmark?.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkNews(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun setStatusBookmark(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding?.iconBookmark?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_bookmark_active))
        } else {
            binding?.iconBookmark?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.ic_bookmark_inactive))
        }
    }
}