package ru.geekbrains.android2.gitclient.data.user

import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserDataSourceFactory
import ru.geekbrains.android2.gitclient.data.user.datasource.UserDataSourceFactory

object GitHubUserRepositoryFactory {
    private val repository: GitHubUserRepository by lazy {
        GitHubUserRepositoryImpl(
            UserDataSourceFactory.create(),
            CacheUserDataSourceFactory.create()
        )
    }

    fun create(): GitHubUserRepository = repository
}