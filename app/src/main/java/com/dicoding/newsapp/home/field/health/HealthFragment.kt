package com.dicoding.newsapp.home.field.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.adapterhome.HealthCategoryAdapter
import com.dicoding.newsapp.databinding.FragmentHealthBinding
import com.dicoding.newsapp.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HealthFragment : Fragment() {
    private val healthViewModel: HealthViewModel by viewModels()

    private var binding: FragmentHealthBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHealthBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val healthAdapter = HealthCategoryAdapter()
            healthAdapter.onItemClick = { selectedData ->
                val detailFragment = DetailFragment()
                val mBundle = Bundle()
                mBundle.putParcelable(DetailFragment.EXTRA_HEALTH, selectedData)
                detailFragment.arguments = mBundle

                detailFragment.show(childFragmentManager, "TAG")

            }

            healthViewModel.healthNews.observe(viewLifecycleOwner, { news ->
                if (news != null) {
                    when (news) {
                        is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding?.progressBar?.visibility = View.GONE
                            healthAdapter.setData(news.data)
                        }
                        is Resource.Error -> {
                            binding?.progressBar?.visibility = View.GONE
                            binding?.viewError?.tvError?.text = news.message ?: getString(R.string.oops_something_went_wrong)
                        }
                    }
                }
            })

            with(binding?.rvCategory) {
                this?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                this?.setHasFixedSize(true)
                this?.adapter = healthAdapter
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}