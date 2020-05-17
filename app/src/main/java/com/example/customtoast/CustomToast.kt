package com.example.customtoast

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.NinePatchDrawable
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import kotlinx.android.synthetic.main.toast_view.view.*


class CustomToast {

    companion object {

        fun create(
            context: Context,
            title: String,
            subtitle: String,
            gravity: Int? = null
        ) {
            val toast = Toast.makeText(context, "", Toast.LENGTH_SHORT)

            gravity?.let {
                //hardcoding x and y offset for now
                toast.setGravity(it, Utils.dpToPx(0), Utils.dpToPx(24))
            }

            val toastView = LayoutInflater.from(context).inflate(
                R.layout.toast_view, null
            )

            toastView.background = tint9PatchDrawableFrame(context)
            toastView.toast_title.text = title
            toastView.toast_subtitle.text = subtitle

            toast.view = toastView

            toast.show()
        }

        private fun getBackgroundDrawable(context: Context, cornerRadius: Int = 0): GradientDrawable {
            val bgDrawable = GradientDrawable()
            bgDrawable.cornerRadius = Utils.dpToPx(cornerRadius).toFloat()
            bgDrawable.setColor(context.resources.getColor(R.color.colorAccent))
            return bgDrawable
        }

        private fun tint9PatchDrawableFrame(
            context: Context
        ): Drawable {
            val toastDrawable: NinePatchDrawable = AppCompatResources.getDrawable(context, R.drawable.round_yellow) as NinePatchDrawable
            toastDrawable.setColorFilter(context.resources.getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN)
            return toastDrawable
        }

    }

}