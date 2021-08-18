package ru.geekbrains.android2.gitclient.data.user.datasource

import ru.geekbrains.android2.gitclient.App
import ru.geekbrains.android2.gitclient.data.storage.GitHubStorageFactory

object CacheUserDataSourceFactory {
    fun create(): CacheUserDataSource =
        CacheUserDataSourceImpl(GitHubStorageFactory.create(App.ContextHolder.context))
}