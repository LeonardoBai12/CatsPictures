package io.lb.stefaniniandroidchallenge.ui.picture

import android.app.Activity
import android.app.Dialog
import android.graphics.Point
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.bumptech.glide.Glide
import io.lb.stefaniniandroidchallenge.R
import io.lb.stefaniniandroidchallenge.model.picture.Picture
import kotlinx.android.synthetic.main.dialog_picture_dialog.*
import kotlin.math.roundToInt

class PictureDialog(
    private val activity: Activity,
    private val picture: Picture
    ) : Dialog(activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_picture_dialog)

        setupView()
    }

    private fun setupView() {
        val size = Point()
        activity.windowManager.defaultDisplay.getSize(size)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(window!!.attributes)
        lp.width = (size.x * 0.9f).roundToInt()

        window!!.attributes = lp

        tvPictureTitle.text = picture.title
        tvPictureDescription.text = picture.description
        tvPictureViews.text = (picture.views ?: 0).toString()

        Glide.with(ivPicture).load(picture.url).into(ivPicture)
    }
}