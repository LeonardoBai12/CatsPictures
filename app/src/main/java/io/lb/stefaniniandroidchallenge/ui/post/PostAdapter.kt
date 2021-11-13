package io.lb.stefaniniandroidchallenge.ui.post

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import io.lb.stefaniniandroidchallenge.R
import io.lb.stefaniniandroidchallenge.model.picture.Picture
import io.lb.stefaniniandroidchallenge.ui.picture.PictureDialog
import kotlinx.android.synthetic.main.row_picture.view.*

class PostAdapter(
    private val activity: Activity
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
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

        val requestOptions = RequestOptions.fitCenterTransform()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .override(holder.ivPostPicture.width,holder.ivPostPicture.height)

        Glide.with(holder.ivPostPicture).load(picture?.url)
            .apply(requestOptions).into(holder.ivPostPicture)

        onClickListener(holder, picture)
    }

    private fun onClickListener(
        holder: ViewHolder,
        picture: Picture?
    ) {
        holder.itemView.setOnClickListener {
            if (picture == null) {
                return@setOnClickListener
            }
            val dialog = PictureDialog(activity, picture)
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return pictures?.size ?: 0
    }

    fun updateList(pictures: ArrayList<Picture>?) {
        this.pictures = pictures
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPostPicture: ImageView = view.ivPostPicutre
    }
}