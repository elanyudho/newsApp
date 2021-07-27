package com.dicoding.newsapp.bookmark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.bookmark.databinding.ActivityBookmarkBinding
import com.dicoding.newsapp.bookmark.di.DaggerBookmarkComponent
import com.dicoding.newsapp.core.ui.adapter.NewsHeadlineAdapter
import com.dicoding.newsapp.detail.DetailActivity
import com.dicoding.newsapp.di.BookmarkModuleDependencies
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class BookmarkActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val bookmarkViewModel: BookmarkViewModel by viewModels(){
        factory
    }

    private var binding: ActivityBookmarkBinding? = null

    private lateinit var bookmarkAdapter: NewsHeadlineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        DaggerBookmarkComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    BookmarkModuleDependencies::class.java
                )
            )
            .build()
            .injectNewsHeadline(this)

        getDataBookmark()
    }

    private fun getDataBookmark() {

        bookmarkAdapter = NewsHeadlineAdapter()
        bookmarkAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@BookmarkActivity, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_HEADLINE, selectedData)
            startActivity(intent)
        }

        bookmarkViewModel.newsBookmark.observe(this, { dataBookmark ->
            bookmarkAdapter.setData(dataBookmark)

            binding?.imageView2?.visibility =
                if (dataBookmark.isNotEmpty()) View.GONE else View.VISIBLE
            binding?.textEmptyBookmark?.visibility =
                if (dataBookmark.isNotEmpty()) View.GONE else View.VISIBLE
            binding?.rvCategoryBookmark?.visibility =
                if (dataBookmark.isNotEmpty()) View.VISIBLE else View.GONE
        })

        with(binding?.rvCategoryBookmark) {
            this?.layoutManager = LinearLayoutManager(this@BookmarkActivity)
            this?.setHasFixedSize(true)
            this?.adapter = bookmarkAdapter
        }
    }
}