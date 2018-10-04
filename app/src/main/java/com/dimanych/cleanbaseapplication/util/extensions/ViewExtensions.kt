package com.dimanych.cleanbaseapplication.util.extensions

import android.widget.EditText
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun EditText.string() = text.toString()

fun ImageView.load(url: String) {
    Picasso.get()
            .load(url)
            .into(this)
}