package com.dicoding.newsapp.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.newsapp.R
import com.dicoding.newsapp.bookmark.databinding.FragmentBookmarkBinding
import com.dicoding.newsapp.bookmark.field.business.BookmarkBusinessFragment
import com.dicoding.newsapp.bookmark.field.entertainment.BookmarkEntertainmentFragment
import com.dicoding.newsapp.bookmark.field.headline.BookmarkNewsHeadlineFragment
import com.dicoding.newsapp.bookmark.field.health.BookmarkHealthFragment
import com.dicoding.newsapp.bookmark.field.science.BookmarkScienceFragment
import com.dicoding.newsapp.bookmark.field.sports.BookmarkSportsFragment
import com.dicoding.newsapp.bookmark.field.technology.BookmarkTechnologyFragment
import com.dicoding.newsapp.core.ui.adapter.CategoryPagerAdapter
import com.dicoding.newsapp.core.utils.dp
import com.google.android.material.tabs.TabLayoutMediator

class BookmarkFragment : Fragment() {

    private lateinit var categoryPagerAdapter: CategoryPagerAdapter

    private var _binding: FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCategoryTab()

        setTabItems()

    }

    private fun setCategoryTab() {
        categoryPagerAdapter = CategoryPagerAdapter(
            listOf(
                BookmarkNewsHeadlineFragment(),
                BookmarkBusinessFragment(),
                BookmarkHealthFragment(),
                BookmarkEntertainmentFragment(),
                BookmarkTechnologyFragment(),
                BookmarkScienceFragment(),
                BookmarkSportsFragment()
            ), requireActivity()
        )
        with(binding) {
            viewPagerCategory.adapter = categoryPagerAdapter

            TabLayoutMediator(tabLayoutCategory, viewPagerCategory) {tab, position ->
                when(position){
                    0 -> {
                        tab.text = getString(R.string.headline)
                    }
                    1 -> {
                        tab.text = getString(R.string.business)
                    }
                    2 -> {
                        tab.text = getString(R.string.health)
                    }
                    3 -> {
                        tab.text = getString(R.string.entertainment)
                    }
                    4 -> {
                        tab.text = getString(R.string.technology)
                    }
                    5 -> {
                        tab.text = getString(R.string.science)
                    }
                    6 -> {
                        tab.text = getString(R.string.sports)
                    }
                }
            }.attach()
        }
    }

    private fun setTabItems() {
        with(binding.tabLayoutCategory) {
            // Set margins
            setTabsMargin(0, 6.dp, 12.dp, 6.dp)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}