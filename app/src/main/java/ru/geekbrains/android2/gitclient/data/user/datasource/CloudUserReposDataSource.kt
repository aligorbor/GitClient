package ru.geekbrains.android2.gitclient.data.user.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.api.GitHubApi
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepos

class CloudUserReposDataSource(private val gitHubApi: GitHubApi) : UserReposDataSource {

    override fun getUserRepos(reposUrl: String): Single<List<GitHubUserRepos>> =
        gitHubApi.getUserRepositories(reposUrl)

}