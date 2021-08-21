package ru.geekbrains.android2.gitclient.data.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.geekbrains.android2.gitclient.presentation.MainActivity
import ru.geekbrains.android2.gitclient.presentation.repos.ReposFragment
import ru.geekbrains.android2.gitclient.presentation.user.UserFragment
import ru.geekbrains.android2.gitclient.presentation.users.UsersFragment

@Module
interface UIModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindUsersFragment(): UsersFragment

    @ContributesAndroidInjector
    fun bindUserFragment(): UserFragment

    @ContributesAndroidInjector
    fun bindReposFragment(): ReposFragment
}