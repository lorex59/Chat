package com.example.fake.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.fake.MainActivity
import com.example.fake.R
import com.example.fake.databinding.FragmentChangeUsernameBinding
import com.example.fake.ui.utilits.*
import java.util.*


class ChangeUsernameFragment : Fragment() {

    private lateinit var binding: FragmentChangeUsernameBinding
    lateinit var newUsername: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChangeUsernameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        binding.settingsInputUsername.setText(USER.username)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.settings_menu_confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings_confirm_change -> change()
        }
        return true
    }

    private fun change() {
        newUsername = binding.settingsInputUsername.text.toString().lowercase(Locale.getDefault())
        if (newUsername.isEmpty()) {
            showToast("Поле пустое")
        } else {
            REF_DATA_BASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                    if (it.hasChild(newUsername)) {
                        showToast("Такое имя уже занято")
                    } else {
                        changeUsername()
                    }
                })
        }
    }

    private fun changeUsername() {
        REF_DATA_BASE_ROOT.child(NODE_USERNAMES).child(newUsername).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateCurrentUsername()
                }
            }
    }

    private fun updateCurrentUsername() {
        REF_DATA_BASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USERNAME)
            .setValue(newUsername)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Данные обновлены")
                    deleteOldUsername()
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUsername() {
        REF_DATA_BASE_ROOT.child(NODE_USERNAMES).child(USER.username)
            .removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Данные обновлены")
                    parentFragmentManager.popBackStack()
                    USER.username = newUsername
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }
}