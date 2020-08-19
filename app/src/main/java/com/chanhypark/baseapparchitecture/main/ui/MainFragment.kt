package com.chanhypark.baseapparchitecture.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel
import kotlinx.android.synthetic.main.fragmnet_detail.*


class MainFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
//    val viewModel:MainViewModel by viewModels ({requireParentFragment()})


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragmnet_detail, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()

    }


    fun observeData() {
        mainViewModel.pictureList.observe(viewLifecycleOwner, Observer {
            view_pager.adapter = ImagePagerAdapter(it, mainViewModel)
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}