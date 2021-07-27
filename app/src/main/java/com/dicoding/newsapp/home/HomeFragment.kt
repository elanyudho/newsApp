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
import com.dicoding.newsapp.core.ui.adapter.NewsHeadlineAdapter
import com.dicoding.newsapp.databinding.FragmentHomeBinding
import com.dicoding.newsapp.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var categoryPagerAdapter: CategoryPagerAdapter

    private lateinit var newsHeadlineAdapter: NewsHeadlineAdapter

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
            newsHeadlineAdapter = NewsHeadlineAdapter()
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

    override fun onDestroyView() {
        _binding = null
        newsHeadlineAdapter.onItemClick = null
        super.onDestroyView()
    }

}