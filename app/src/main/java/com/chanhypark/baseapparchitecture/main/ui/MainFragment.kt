package com.chanhypark.baseapparchitecture.main.ui

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.ui.view_model.MainViewModel
import kotlinx.android.synthetic.main.fragmnet_main.*


class MainFragment : Fragment() {
    private val mainViewModel: MainViewModel by activityViewModels()
//    val viewModel:MainViewModel by viewModels ({requireParentFragment()})


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragmnet_main, container, false)


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeData()

        val imm =activity?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        tv_hint.setOnClickListener {
            tv_hint.visibility = View.GONE
            edit_text.requestFocus()
            imm.showSoftInput(edit_text,0)
        }


        edit_text.setOnFocusChangeListener { view, b ->
            if(b || !edit_text.text.isNullOrEmpty()) tv_hint.visibility = View.GONE
            else tv_hint.visibility = View.VISIBLE
        }
    }


    fun observeData() {
        mainViewModel.userList.observe(viewLifecycleOwner, Observer {
            context?.let { context ->
//                rv_user.adapter = UserAdapter(context).apply{
//                    collections = it
//                }
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }
}