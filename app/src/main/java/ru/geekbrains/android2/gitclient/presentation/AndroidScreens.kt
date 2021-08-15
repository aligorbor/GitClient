package ru.geekbrains.android2.gitclient.presentation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.android2.gitclient.presentation.user.UserFragment
import ru.geekbrains.android2.gitclient.presentation.users.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(textLogin: String) = FragmentScreen { UserFragment.newInstance(textLogin) }
}
