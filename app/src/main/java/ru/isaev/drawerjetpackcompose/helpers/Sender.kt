package ru.isaev.drawerjetpackcompose.helpers

import com.google.firebase.auth.PhoneAuthProvider

object Sender {
    lateinit var idString: String

    lateinit var mToken: PhoneAuthProvider.ForceResendingToken
}