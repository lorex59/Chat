package com.example.fake.ui.utilits

import com.example.fake.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var AUTH: FirebaseAuth
lateinit var UID: String
lateinit var REF_DATA_BASE_ROOT: DatabaseReference
lateinit var User: User

const val NODE_USERS = "users"
const val CHILD_OD = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"


fun initFirebase() {
    AUTH = FirebaseAuth.getInstance()
    REF_DATA_BASE_ROOT = FirebaseDatabase.getInstance().reference
    User = User()
    UID = AUTH.currentUser?.uid.toString()
}
