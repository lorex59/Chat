package com.example.fake.utilits

import android.util.Log

enum class AppStates(val state: String) {
    ONLINE("В сети"),
    OFFLINE("Был недавно"),
    TYPING("печатает");

    companion object {
        fun updateState(appStates: AppStates) {
            REF_DATA_BASE_ROOT.child(NODE_USERS).child(CURRENT_UID).child(CHILD_STATE)
                .setValue(appStates.state).addOnSuccessListener {
                    USER.state = appStates.state
                }
                .addOnFailureListener { Log.d("Tag", it.message.toString())}
        }
    }
}