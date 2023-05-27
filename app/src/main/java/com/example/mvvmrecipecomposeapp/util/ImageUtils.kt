//package com.example.mvvmrecipecomposeapp.util
//
//import android.graphics.Bitmap
//import androidx.annotation.DrawableRes
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.MutableState
//import com.bumptech.glide.Glide
//
//@Composable
//fun loadPicture(
//    url: String,
//    @DrawableRes defaultImage: Int
//):MutableState<Bitmap?>{
//    val bitmapState: MutableState<Bitmap>
//
//    Glide.with(AmbientContext.current)
//        .asBitmap()
//        .load(defaultImage)
//        .into(object CustomTarget<Bitmap>(){
//
//        })
//}