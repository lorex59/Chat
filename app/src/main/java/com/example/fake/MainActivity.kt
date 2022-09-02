package com.example.fake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.fake.activities.RegisterActivity
import com.example.fake.databinding.ActivityMainBinding
import com.example.fake.ui.fragments.ChatsFragment
import com.example.fake.ui.objects.AppDrawer
import com.example.fake.ui.utilits.AUTH
import com.example.fake.ui.utilits.initFirebase
import com.example.fake.ui.utilits.replaceActivity
import com.example.fake.ui.utilits.replaceFragment
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var appDrawer: AppDrawer
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

        if (AUTH.currentUser != null) {
            setSupportActionBar(toolBar)
            appDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }

    }


    private fun initFields() {
        toolBar = binding.mainToolBar
        appDrawer = AppDrawer(this, toolBar)
        initFirebase()
    }
}