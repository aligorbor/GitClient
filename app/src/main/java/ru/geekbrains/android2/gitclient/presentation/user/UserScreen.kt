package ru.geekbrains.android2.gitclient.presentation.user

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class UserScreen(private val userLogin: String) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        UserFragment.newInstance(userLogin)

}