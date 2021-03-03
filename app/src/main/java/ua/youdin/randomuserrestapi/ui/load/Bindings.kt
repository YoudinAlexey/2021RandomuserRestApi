package ua.youdin.randomuserrestapi.ui.load

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ua.youdin.randomuserrestapi.R
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data
import java.util.*

@SuppressLint("SetTextI18n")
@BindingAdapter("name")
fun bindName(textView: TextView, data:Data){
    textView.text= "${data.name?.last} ${data.name?.first}".toUpperCase(Locale.ROOT)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, url:String){
    url.let {
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}