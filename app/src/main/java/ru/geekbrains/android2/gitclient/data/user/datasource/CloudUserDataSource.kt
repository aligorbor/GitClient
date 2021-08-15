package ru.geekbrains.android2.gitclient.data.user.datasource


import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.api.GitHubApi
import ru.geekbrains.android2.gitclient.data.user.GitHubUser

class CloudUserDataSource(private val gitHubApi: GitHubApi) : UserDataSource {
    override fun getUsers(): Single<List<GitHubUser>> =
        gitHubApi.getUsers()

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        gitHubApi.getUserByLogin(userId)
            .toMaybe()
}