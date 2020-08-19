package com.chanhypark.baseapparchitecture.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun AppCompatActivity.replaceFragmentInActivity(fragment: Fragment, frameId: Int) {
    supportFragmentManager.transact {
        replace(frameId, fragment)
    }
}


fun AppCompatActivity.addFragment(fragment: Fragment, frameId: Int){
    supportFragmentManager.transact {
        add(frameId,fragment)
    }
}


fun AppCompatActivity.addFragmentWithStack(fragment: Fragment, frameId: Int, name:String? = null){
    supportFragmentManager.transact {
        add(frameId,fragment)
        addToBackStack(name)
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}
