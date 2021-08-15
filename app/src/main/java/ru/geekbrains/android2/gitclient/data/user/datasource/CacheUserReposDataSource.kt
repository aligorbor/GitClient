package ru.geekbrains.android2.gitclient.data.user.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepos

interface CacheUserReposDataSource : UserReposDataSource {

    fun retain(userRepos: List<GitHubUserRepos>, reposUrl: String): Single<List<GitHubUserRepos>>

}