package com.example.fake

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.activities.RegisterActivity

import com.example.fake.databinding.ActivityMainBinding
import com.example.fake.ui.fragments.ChatsFragment
import com.example.fake.ui.objects.AppDrawer
import com.example.fake.ui.utilits.replaceActivity
import com.example.fake.ui.utilits.replaceFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appDrawer: AppDrawer
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {

        if (true) {
            setSupportActionBar(toolBar)
            appDrawer.create()
            replaceFragment(ChatsFragment())
        } else {
            replaceActivity(RegisterActivity())
        }

    }


    private fun initFields() {
        toolBar = binding.mainToolBar
        appDrawer = AppDrawer(this, toolBar)
    }
}