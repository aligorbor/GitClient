package ru.geekbrains.android2.gitclient.data.user.datasource

import ru.geekbrains.android2.gitclient.data.api.GitHubApiFactory

object UserReposDataSourceFactory {
    fun create(): UserReposDataSource = CloudUserReposDataSource(GitHubApiFactory.create())
}