package com.demo.assignment.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.demo.assignment.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


@BindingAdapter("avatar")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .placeholder(R.drawable.placeholder).noFade()
        .into(view, object : Callback {
            override fun onSuccess() {
                view.alpha = 0f
                view.animate().setDuration(500).alpha(1f).start()
            }

            override fun onError(e: Exception) {}
        })
}






