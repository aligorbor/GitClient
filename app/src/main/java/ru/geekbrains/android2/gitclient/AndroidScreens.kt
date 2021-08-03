package ru.geekbrains.android2.gitclient

import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(textLogin: String) = FragmentScreen { UserFragment.newInstance(textLogin) }
}
