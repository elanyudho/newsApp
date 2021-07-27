package com.dicoding.newsapp.bookmark.field.health

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.newsapp.bookmark.BookmarkViewModel
import com.dicoding.newsapp.bookmark.DaggerBookmarkComponent
import com.dicoding.newsapp.bookmark.ViewModelFactory
import com.dicoding.newsapp.bookmark.databinding.FragmentBookmarkHealthBinding
import com.dicoding.newsapp.core.ui.adapter.adapterbookmark.HealthAdapter
import com.dicoding.newsapp.detail.DetailFragment
import com.dicoding.newsapp.di.BookmarkModuleDependencies
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class BookmarkHealthFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val bookmarkViewModel: BookmarkViewModel by viewModels(){
        factory
    }

    private var binding: FragmentBookmarkHealthBinding? = null

    private  var bookmarkAdapter: HealthAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkHealthBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerBookmarkComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext(),
                    BookmarkModuleDependencies::class.java
                )
            )
            .build()
            .injectHealth(this)

        if (activity != null) {

            bookmarkAdapter = HealthAdapter()
            bookmarkAdapter?.onItemClick = { selectedData ->
                val detailFragment = DetailFragment()
                val mBundle = Bundle()
                mBundle.putParcelable(DetailFragment.EXTRA_HEALTH, selectedData)
                detailFragment.arguments = mBundle

                detailFragment.show(childFragmentManager, "TAG")
            }

            bookmarkViewModel.healthBookmark.observe(viewLifecycleOwner, { dataBookmark ->
                bookmarkAdapter?.setData(dataBookmark)

                binding?.imageView2?.visibility =
                    if (dataBookmark.isNotEmpty()) View.GONE else View.VISIBLE
                binding?.textEmptyBookmark?.visibility =
                    if (dataBookmark.isNotEmpty()) View.GONE else View.VISIBLE
                binding?.rvCategoryBookmark?.visibility =
                    if (dataBookmark.isNotEmpty()) View.VISIBLE else View.GONE
            })

            with(binding?.rvCategoryBookmark) {
                this?.layoutManager = LinearLayoutManager(requireContext())
                this?.setHasFixedSize(true)
                this?.adapter = bookmarkAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvCategoryBookmark?.let { it.adapter = null }
        bookmarkAdapter = null
        binding = null
    }
}