package com.example.fake.utilits

import com.example.fake.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

lateinit var AUTH: FirebaseAuth
lateinit var CURRENT_UID: String
lateinit var REF_DATA_BASE_ROOT: DatabaseReference
lateinit var REF_STORAGE_ROOT: StorageReference
lateinit var USER: User

const val NODE_USERS = "users"
const val NODE_USERNAMES = "usernames"

const val CHILD_ID = "id"
const val CHILD_BIO = "bio"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"


fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATA_BASE_ROOT = FirebaseDatabase.getInstance().reference
    REF_STORAGE_ROOT = FirebaseStorage.getInstance().reference
    USER = User()
    CURRENT_UID = AUTH.currentUser?.uid.toString()

}

inline fun initUser(crossinline function: () -> Unit) {
    REF_DATA_BASE_ROOT.child(NODE_USERS).child(CURRENT_UID)
        .addListenerForSingleValueEvent(AppValueEventListener {
            USER = it.getValue(User::class.java) ?: User()
            if (USER.username.isEmpty()) {
                USER.username = CURRENT_UID
            }
            function()
        })
}