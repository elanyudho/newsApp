package com.dicoding.newsapp.home.field.technology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.data.source.Resource
import com.dicoding.newsapp.core.ui.adapter.adapterhome.TechnologyCategoryAdapter
import com.dicoding.newsapp.databinding.FragmentTechnologyBinding
import com.dicoding.newsapp.detail.DetailFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TechnologyFragment : Fragment() {
    private val technologyViewModel: TechnologyViewModel by viewModels()

    private var binding: FragmentTechnologyBinding? = null

    private var technologyAdapter: TechnologyCategoryAdapter? = null

    private var detailFragment: DetailFragment? = null

    private var mBundle: Bundle? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTechnologyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        technologyAdapter = TechnologyCategoryAdapter()
        technologyAdapter?.onItemClick = { selectedData ->
            detailFragment = DetailFragment()
            mBundle = Bundle()
            mBundle?.putParcelable(DetailFragment.EXTRA_TECHNOLOGY, selectedData)
            detailFragment?.arguments = mBundle

            detailFragment?.show(childFragmentManager, "TAG")

        }

        technologyViewModel.technologyNews.observe(viewLifecycleOwner, { news ->
            if (news != null) {
                when (news) {
                    is Resource.Loading -> binding?.progressBar?.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding?.progressBar?.visibility = View.GONE
                        technologyAdapter?.setData(news.data)
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
            this?.adapter = technologyAdapter
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvCategory?.let { it.adapter = null }
        requireActivity().setActionBar(null)
        detailFragment = null
        mBundle = null
        technologyAdapter = null
        binding = null
    }
}