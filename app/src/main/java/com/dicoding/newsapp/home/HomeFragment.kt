package com.dicoding.newsapp.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.CategoryPagerAdapter
import com.dicoding.newsapp.core.ui.adapter.adapterbookmark.NewsHeadlineAdapter
import com.dicoding.newsapp.core.utils.dp
import com.dicoding.newsapp.databinding.FragmentHomeBinding
import com.dicoding.newsapp.detail.DetailFragment
import com.dicoding.newsapp.home.field.business.BusinessFragment
import com.dicoding.newsapp.home.field.entertainment.EntertainmentFragment
import com.dicoding.newsapp.home.field.health.HealthFragment
import com.dicoding.newsapp.home.field.science.ScienceFragment
import com.dicoding.newsapp.home.field.sports.SportsFragment
import com.dicoding.newsapp.home.field.technology.TechnologyFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var categoryPagerAdapter: CategoryPagerAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDataHeadline()

        setCategoryTab()

        setTabItems()

    }

    private fun getDataHeadline() {
        if (activity != null) {
            val newsHeadlineAdapter = NewsHeadlineAdapter()
            newsHeadlineAdapter.onItemClick = { selectedData ->
                val detailFragment = DetailFragment()
                val mBundle = Bundle()
                mBundle.putParcelable(DetailFragment.EXTRA_HEADLINE, selectedData)
                detailFragment.arguments = mBundle

                detailFragment.show(childFragmentManager, "TAG")

            }

            homeViewModel.newsHeadline.observe(viewLifecycleOwner, { news ->
                if (news != null) {
                    when (news) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            newsHeadlineAdapter.setData(news.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.tvError.text =
                                news.message ?: getString(R.string.oops_something_went_wrong)
                        }
                    }
                }
            })

            with(binding.rvHeadline) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = newsHeadlineAdapter
            }
        }
    }

    private fun setCategoryTab() {
        categoryPagerAdapter = CategoryPagerAdapter(
            listOf(
                BusinessFragment(),
                HealthFragment(),
                EntertainmentFragment(),
                TechnologyFragment(),
                ScienceFragment(),
                SportsFragment()
            ), requireActivity()
        )
        with(binding) {
            viewPagerCategory.adapter = categoryPagerAdapter
            viewPagerCategory.setUserInputEnabled(false)

            TabLayoutMediator(tabLayoutCategory, viewPagerCategory) {tab, position ->
                when(position){
                    0 -> {
                        tab.text = getString(R.string.business)
                    }
                    1 -> {
                        tab.text = getString(R.string.health)
                    }
                    2 -> {
                        tab.text = getString(R.string.entertainment)
                    }
                    3 -> {
                        tab.text = getString(R.string.technology)
                    }
                    4 -> {
                        tab.text = getString(R.string.science)
                    }
                    5 -> {
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
        super.onDestroyView()
        _binding = null
    }

}