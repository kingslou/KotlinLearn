package com.example.kotlinlearn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class DashFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val user = User("1111",1)

        println(user.userName+"年龄"+user.userAge)

        user.userTest = "我是测试"

        println(user.userTest)

        return inflater!!.inflate(R.layout.fragment_dash, container, false)
    }

    fun updateUserInfo(user: User){

    }
}