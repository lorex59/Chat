package com.example.fake.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.activities.RegisterActivity
import com.example.fake.MainActivity
import com.example.fake.R
import com.example.fake.databinding.FragmentEnterPhoneNumberBinding
import com.example.fake.databinding.FragmentSettingsBinding
import com.example.fake.ui.utilits.AUTH
import com.example.fake.ui.utilits.replaceActivity


class SettingsFragment : Fragment(R.layout.fragment_settings) {


    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
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
        }
        return true
    }
}