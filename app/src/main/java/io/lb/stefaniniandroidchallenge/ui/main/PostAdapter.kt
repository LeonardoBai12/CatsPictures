package io.lb.stefaniniandroidchallenge.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.lb.stefaniniandroidchallenge.R
import io.lb.stefaniniandroidchallenge.model.picture.Picture
import kotlinx.android.synthetic.main.row_picture.view.*

class PostAdapter : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    private var pictures: ArrayList<Picture>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view  = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_picture, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val picture = pictures?.get(position)

        Glide.with(holder.ivPostPicutre)
            .load(picture?.url)
            .into(holder.ivPostPicutre)
    }

    override fun getItemCount(): Int {
        return pictures?.size ?: 0
    }

    fun updateList(pictures: ArrayList<Picture>?) {
        this.pictures = pictures
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPostPicutre: ImageView = view.ivPostPicutre
    }
}