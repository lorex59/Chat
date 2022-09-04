package com.example.fake.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.fake.activities.RegisterActivity
import com.example.fake.MainActivity
import com.example.fake.R
import com.example.fake.databinding.FragmentSettingsBinding
import com.example.fake.utilits.AUTH
import com.example.fake.utilits.USER
import com.example.fake.utilits.replaceActivity
import com.example.fake.utilits.replaceFragment


class SettingsFragment : Fragment(R.layout.fragment_settings) {


    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        (activity as MainActivity).appDrawer.disableDrawer()
    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).appDrawer.enabledDrawer()
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }

    private fun initFields() {
        with(binding) {
            settingUserName.text = USER.username
            settingFullName.text = USER.fullname
            settingBio.text = USER.bio
            settingPhoneNumber.text = USER.phone
            settingStatus.text = USER.status
            settingBtnChangeUserName.setOnClickListener {
                replaceFragment(ChangeUsernameFragment())
            }
            settingBtnChangeBio.setOnClickListener {
                replaceFragment(ChangeBioFragment())
            }
            settingChangePhoto.setOnClickListener {
                changePhotoUser()
            }
        }
    }

    private fun changePhotoUser() {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> {
                replaceFragment(ChangeNameFragment())
            }
        }
        return true
    }
}