package com.chanhypark.baseapparchitecture.main

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.core.graphics.values
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.chanhypark.baseapparchitecture.R
import com.chanhypark.baseapparchitecture.data.model.User
import com.chanhypark.baseapparchitecture.main.util.CustomViewPager
import com.chanhypark.baseapparchitecture.main.util.ScaleImageView
import com.github.chrisbanes.photoview.PhotoView


class ImagePagerAdapter constructor(
    private val imgList : List<User.Picture>, private val mainViewModel: MainViewModel
): PagerAdapter(){

    private var enabled = false
    override fun instantiateItem(container: View, position: Int): Any {
        val imageLayout = LayoutInflater.from(container.context).inflate(R.layout.item_picture_image, null)
        val ivPicture = imageLayout.findViewById<ImageView>(R.id.iv_picture)


        with(imgList[position]){
            Glide.with(container.context)
                .load(large)
                .into(ivPicture)
        }

        (container as CustomViewPager).setPagingEnabled(true)


        //이미지의 scale이 변경시 뷰페이저의 페이징을 조절함
        (ivPicture as ScaleImageView).attacher.setOnScaleChangeListener { _, _, _ ->
            if((ivPicture).attacher.imageMatrix.values()[0] <= 1.0f)
                container.setPagingEnabled(true)
            else
                container.setPagingEnabled(false)
            }

//

        (container as ViewPager).addView(imageLayout)



        return imageLayout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int = imgList.size


    override fun destroyItem(container: View, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as View)
    }



}