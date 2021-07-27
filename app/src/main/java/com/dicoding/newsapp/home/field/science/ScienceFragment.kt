package com.dicoding.newsapp.home.field.science

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.adapterhome.ScienceCategoryAdapter
import com.dicoding.newsapp.databinding.FragmentScienceBinding
import com.dicoding.newsapp.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScienceFragment : Fragment() {
    private val scienceViewModel: ScienceViewModel by viewModels()

    private var binding: FragmentScienceBinding? = null

    private var scienceAdapter: ScienceCategoryAdapter? = null

    private var detailFragment: DetailFragment? = null

    private var mBundle: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScienceBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scienceAdapter = ScienceCategoryAdapter()
        scienceAdapter?.onItemClick = { selectedData ->
            detailFragment = DetailFragment()
            mBundle = Bundle()
            mBundle?.putParcelable(DetailFragment.EXTRA_SCIENCE, selectedData)
            detailFragment?.arguments = mBundle

            detailFragment?.show(childFragmentManager, "TAG")

        }

        scienceViewModel.scienceNews.observe(viewLifecycleOwner, { news ->
            if (news != null) {
                when (news) {
                    is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        scienceAdapter?.setData(news.data)
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
            this?.adapter = scienceAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvCategory?.let { it.adapter = null }
        requireActivity().setActionBar(null)
        detailFragment = null
        mBundle = null
        scienceAdapter = null
        binding = null
    }
}