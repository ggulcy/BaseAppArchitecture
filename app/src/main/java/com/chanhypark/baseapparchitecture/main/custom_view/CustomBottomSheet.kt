package com.chanhypark.baseapparchitecture.main.custom_view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.getDeviceSize
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_fragment.view.*


class CustomBottomSheet() : BottomSheetDialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =inflater.inflate(R.layout.dialog_fragment,container,false)

        return view
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val d = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
//        d.setOnShowListener {
//            val dialog = d as BottomSheetDialog
//            val behavior= BottomSheetBehavior.from(dialog.findViewById(R.id.rl_bottom_sheet)!!)
//
//            behavior.state = BottomSheetBehavior.STATE_EXPANDED
//            behavior.skipCollapsed = true
//            behavior.isHideable = true
//
//            println("chanhypark@@ : ${behavior.state}")
//
//        }
        return d


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val behavior = BottomSheetBehavior.from(view.rl_bottom_sheet)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.peekHeight = (getDeviceSize(context).second * 0.9).toInt()
        view.rl_bottom_sheet.layoutParams.apply {
            height = (getDeviceSize(context).second * 0.9).toInt()
        }

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                println("STATE CHANGE : $newState")
            }

        })






    }

//    override fun getTheme(): Int {
//        return R.style.BottomSheetDialog
//    }



        companion object {
        const val TAG_DIALOG = "dialog_frg"
        fun newInstance(): CustomBottomSheet {
            return CustomBottomSheet()
        }
    }


}


