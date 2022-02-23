package ru.isaev.drawerjetpackcompose.helpers

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.isaev.drawerjetpackcompose.models.Users
import ru.isaev.drawerjetpackcompose.ui.screens.SettingsScreen.SettingViewModel

lateinit var Auth: FirebaseAuth
lateinit var Ref_Database_Root: DatabaseReference
lateinit var Uid: String
lateinit var User:Users

const val NODE_USERNAME = "username"
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

fun initUsers(viewModel: SettingViewModel){
    CoroutineScope(Dispatchers.IO).launch {
        Ref_Database_Root.child(NODE_USER).child(Uid)
            .addListenerForSingleValueEvent(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    User = snapshot.getValue(Users::class.java) ?: Users()

                    val fullnameList = User.fullname.split(" ")
                    val username = User.username
                    viewModel._name.value = fullnameList[0]
                    viewModel._surname.value = fullnameList[1]
                    viewModel._username.value =  username

                }

                override fun onCancelled(error: DatabaseError) {
                }

            })
    }

}
