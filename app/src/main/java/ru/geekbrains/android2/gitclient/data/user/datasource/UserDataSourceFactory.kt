package ru.geekbrains.android2.gitclient.data.user.datasource

import ru.geekbrains.android2.gitclient.data.api.GitHubApiFactory

object UserDataSourceFactory {
    fun create(): UserDataSource = CloudUserDataSource(GitHubApiFactory.create())
}