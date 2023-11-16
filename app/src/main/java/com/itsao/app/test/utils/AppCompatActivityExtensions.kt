package com.itsao.app.test.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
inline fun <reified T: AppCompatActivity> AppCompatActivity.launchActivity(){
    startActivity(Intent(this, T::class.java))
    finish()
}