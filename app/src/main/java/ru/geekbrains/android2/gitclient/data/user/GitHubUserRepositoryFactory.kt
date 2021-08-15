package ru.geekbrains.android2.gitclient.data.user

import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserDataSourceFactory
import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserReposDataSourceFactory
import ru.geekbrains.android2.gitclient.data.user.datasource.UserDataSourceFactory
import ru.geekbrains.android2.gitclient.data.user.datasource.UserReposDataSourceFactory

object GitHubUserRepositoryFactory {
    fun create(): GitHubUserRepository =
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create(),
            UserReposDataSourceFactory.create(),
            CacheUserReposDataSourceFactory.create()
        )
}