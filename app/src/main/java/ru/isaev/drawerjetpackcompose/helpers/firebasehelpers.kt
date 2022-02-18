package ru.isaev.drawerjetpackcompose.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.isaev.drawerjetpackcompose.models.Users

lateinit var Auth: FirebaseAuth
lateinit var Ref_Database_Root: DatabaseReference
lateinit var Uid: String
lateinit var User:Users

const val NODE_USER = "users"
const val CHILD_ID = "id"
const val CHILD_PHONE = "phone"
const val CHILD_USERNAME = "username"
const val CHILD_FULLNAME = "fullname"

fun initFirebase(){
    Ref_Database_Root = FirebaseDatabase.getInstance().reference
    Auth = FirebaseAuth.getInstance()
    User = Users()
    Uid = Auth.currentUser?.uid.toString()
}
