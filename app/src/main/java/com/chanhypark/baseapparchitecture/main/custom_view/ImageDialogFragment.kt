package com.chanhypark.baseapparchitecture.main.custom_view

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.main.getDeviceSize
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.dialog_fragment.view.*


class ImageDialogFragment constructor(): DialogFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME,R.style.AppTheme)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_fragment,container)
        val bottomSheetBehavior = BottomSheetBehavior.from(view.rl_bottom_sheet)


        return view
    }

    override fun onResume() {
        super.onResume()
        dialog?.apply {
            window?.setLayout(
//                (getDeviceSize(dialog?.context).first * 1).toInt(),
//                (getDeviceSize(dialog?.context).second * 1).toInt()
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

    }


    companion object{
        const val TAG_DIALOG = "dialog_frg"
        fun newInstance():ImageDialogFragment{
            return ImageDialogFragment()
        }
    }

}