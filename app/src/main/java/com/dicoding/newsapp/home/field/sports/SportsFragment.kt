package com.dicoding.newsapp.home.field.sports

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.adapterhome.SportsCategoryAdapter
import com.dicoding.newsapp.databinding.FragmentSportsBinding
import com.dicoding.newsapp.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SportsFragment : Fragment() {
    private val sportsViewModel: SportsViewModel by viewModels()

    private var binding: FragmentSportsBinding? = null

    private var sportsAdapter: SportsCategoryAdapter? = null

    private var detailFragment: DetailFragment? = null

    private var mBundle: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sportsAdapter = SportsCategoryAdapter()
        sportsAdapter?.onItemClick = { selectedData ->
            val detailFragment = DetailFragment()
            val mBundle = Bundle()
            mBundle.putParcelable(DetailFragment.EXTRA_SPORTS, selectedData)
            detailFragment.arguments = mBundle

            detailFragment.show(childFragmentManager, "TAG")

        }

        sportsViewModel.sportsNews.observe(viewLifecycleOwner, { news ->
            if (news != null) {
                when (news) {
                    is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        sportsAdapter?.setData(news.data)
                    }
                    is Resource.Error -> {
                        binding?.progressBar?.visibility = View.GONE
                        binding?.viewError?.tvError?.text = news.message ?: getString(R.string.oops_something_went_wrong)
                    }
                }
            }
        })

        with(binding?.rvCategory) {
            this?.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            this?.setHasFixedSize(true)
            this?.adapter = sportsAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvCategory?.let { it.adapter = null }
        requireActivity().setActionBar(null)
        detailFragment = null
        mBundle = null
        sportsAdapter = null
        binding = null
    }
}