package com.dicoding.newsapp.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.NewsHeadlineAdapter
import com.dicoding.newsapp.databinding.ActivityMainBinding
import com.dicoding.newsapp.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private var binding: ActivityMainBinding? = null

    private lateinit var newsHeadlineAdapter: NewsHeadlineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        getDataHeadline()

        binding?.btnBookmark?.setOnClickListener{
            val uri = Uri.parse("newsapp://bookmark")
            startActivity(Intent(Intent.ACTION_VIEW, uri))

        }
    }

    private fun getDataHeadline() {
        newsHeadlineAdapter = NewsHeadlineAdapter()
        newsHeadlineAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_HEADLINE, selectedData)
            startActivity(intent)

        }

        mainViewModel.newsHeadline.observe(this, { news ->
            if (news != null) {
                when (news) {
                    is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        newsHeadlineAdapter.setData(news.data)
                    }
                    is Resource.Error -> {
                        binding?.progressBar?.visibility = View.GONE
                        binding?.viewError?.tvError?.text =
                            news.message ?: getString(R.string.oops_something_went_wrong)
                    }
                }
            }
        })

        with(binding?.rvHeadline) {
            this?.layoutManager = LinearLayoutManager(this@MainActivity)
            this?.setHasFixedSize(true)
            this?.adapter = newsHeadlineAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("state", "updating state")
        newsHeadlineAdapter.notifyDataSetChanged()
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("state", "updating state on restart")
        newsHeadlineAdapter.notifyDataSetChanged()
    }
}
