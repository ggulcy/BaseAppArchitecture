package com.chanhypark.baseapparchitecture.main.custom_view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction
import com.andrefrsousa.superbottomsheet.SuperBottomSheetFragment
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.getDeviceSize
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_fragment.view.*


class SuperBottomSheet() : SuperBottomSheetFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.dialog_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val behavior = BottomSheetBehavior.from(view.rl_bottom_sheet)
//        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        view.rl_bottom_sheet.layoutParams.apply {

        }

    }

    override fun getPeekHeight(): Int {
        return (getDeviceSize(context).second *0.98).toInt()
    }

    override fun getBackgroundColor(): Int {
        return context!!.getColor(R.color.colorWhite)
    }

    override fun getCornerRadius(): Float {
        return 0f
    }


        companion object {
        const val TAG_DIALOG = "dialog_frg"
        fun newInstance(): SuperBottomSheet {
            return SuperBottomSheet()
        }
    }


}


