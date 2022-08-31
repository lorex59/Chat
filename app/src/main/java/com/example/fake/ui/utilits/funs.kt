package com.example.fake.ui.utilits

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.activities.RegisterActivity
import com.example.fake.R

fun Fragment.showToast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.replaceActivity(activity: Activity) {
    val intent = Intent(this, activity::class.java)
    startActivity(intent)
    this.finish()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.dataContainer, fragment)
        .commit()
}

fun Fragment.replaceFragment(fragment: Fragment) {
    parentFragmentManager.beginTransaction()
        .addToBackStack(null)
        .replace(R.id.dataContainer, fragment)
        .commit()
}