package ua.youdin.randomuserrestapi.ui.detail

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ua.youdin.randomuserrestapi.R
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Login
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Name
import java.util.*


@SuppressLint("SetTextI18n")
@BindingAdapter("detail_name")
fun bindDetailName(textView: TextView, name: Name) {
    textView.text = textView.context.getString(R.string.name)
        .toUpperCase(Locale.ROOT) + " ${name.last} ${name.first}".toUpperCase(Locale.ROOT)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("phone")
fun bindPhone(textView: TextView, phone: String) {
    textView.text =
        textView.context.getString(R.string.phone).toUpperCase(Locale.ROOT) + " ${phone}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("email")
fun bindEmail(textView: TextView, email: String) {
    textView.text =
        textView.context.getString(R.string.email).toUpperCase(Locale.ROOT) + " ${email}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("gender")
fun bindGender(textView: TextView, gender: String) {
    textView.text =
        textView.context.getString(R.string.gender).toUpperCase(Locale.ROOT) + " ${gender}"
}

@SuppressLint("SetTextI18n")
@BindingAdapter("login")
fun bindLogin(textView: TextView, login: Login) {
    textView.text =
        textView.context.getString(R.string.login).toUpperCase(Locale.ROOT) +
                " ${login.username}" + "\n" +
        textView.context.getString(R.string.password).toUpperCase(Locale.ROOT) +
                " ${login.password}"
}