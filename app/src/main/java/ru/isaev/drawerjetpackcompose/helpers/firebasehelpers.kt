package ru.isaev.drawerjetpackcompose.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

lateinit var Auth: FirebaseAuth
lateinit var Ref_Database_Root: DatabaseReference

const val NODE_USER = "users"
const val CHILD_ID = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"

fun initFirebase(){
    Ref_Database_Root = FirebaseDatabase.getInstance().reference
    Auth = FirebaseAuth.getInstance()
}
