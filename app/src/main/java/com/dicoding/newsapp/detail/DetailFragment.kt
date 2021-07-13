package com.dicoding.newsapp.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.dicoding.newsapp.R
import com.dicoding.newsapp.core.domain.model.*
import com.dicoding.newsapp.databinding.FragmentDetailBinding
import com.dicoding.newsapp.webview.WebviewActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_detail.*

@AndroidEntryPoint
class DetailFragment : BottomSheetDialogFragment() {

    companion object {
        const val EXTRA_HEADLINE = "extra_headline"
        const val EXTRA_BUSINESS = "extra_business"
        const val EXTRA_SPORTS = "extra_sports"
        const val EXTRA_SCIENCE = "extra_science"
        const val EXTRA_TECHNOLOGY = "extra_technology"
        const val EXTRA_HEALTH = "extra_health"
        const val EXTRA_ENTERTAINMENT = "extra_entertainment"
    }

    private val detailViewModel: DetailViewModel by viewModels()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val detailNews = arguments?.getParcelable<News>(EXTRA_HEADLINE)
            showDetailHeadline(detailNews)

            val detailBusiness = arguments?.getParcelable<Business>(EXTRA_BUSINESS)
            showDetailBusiness(detailBusiness)

            val detailHealth = arguments?.getParcelable<Health>(EXTRA_HEALTH)
            showDetailHealth(detailHealth)

            val detailSports = arguments?.getParcelable<Sports>(EXTRA_SPORTS)
            showDetailSports(detailSports)

            val detailScience = arguments?.getParcelable<Science>(EXTRA_SCIENCE)
            showDetailScience(detailScience)

            val detailTechnology = arguments?.getParcelable<Technology>(EXTRA_TECHNOLOGY)
            showDetailTechnology(detailTechnology)

            val detailEntertainment = arguments?.getParcelable<Entertainment>(EXTRA_ENTERTAINMENT)
            showDetailEntertainment(detailEntertainment)
        }
    }

    private fun showDetailHeadline(detailNews: News?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkNews(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailBusiness(detailNews: Business?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkBusiness(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailSports(detailNews: Sports?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkSports(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailScience(detailNews: Science?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkScience(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailHealth(detailNews: Health?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkHealth(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailEntertainment(detailNews: Entertainment?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }

            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkEntertainment(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun showDetailTechnology(detailNews: Technology?) {
        detailNews?.let {
            binding.titleDetailNews.text = detailNews.title
            binding.authorDetailNews.text = detailNews.author
            binding.publishedAtDetailNews.text = detailNews.publishedAt
            binding.description.text = detailNews.description
            Glide.with(requireActivity())
                .load(detailNews.urlToImage)
                .into(binding.imageNewsDetail)

            binding.buttonDetail.setOnClickListener {
                val intent = Intent(activity, WebviewActivity::class.java)
                intent.putExtra(WebviewActivity.EXTRA_NEWS, detailNews.url)
                buttonDetail.context.startActivity(intent)
            }


            var statusBookmark = detailNews.isBookmark
            setStatusBookmark(statusBookmark)
            binding.iconBookmark.setOnClickListener {
                statusBookmark = !statusBookmark
                detailViewModel.setBookmarkTechnology(detailNews, statusBookmark)
                setStatusBookmark(statusBookmark)
            }
        }
    }

    private fun setStatusBookmark(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.iconBookmark.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_bookmark_active))
        } else {
            binding.iconBookmark.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.ic_bookmark_inactive))
        }
    }

}