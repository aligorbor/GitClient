package ru.geekbrains.android2.gitclient.data.user.datasource


import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.user.GitHubUser

interface CacheUserDataSource : UserDataSource {

    fun retain(users: List<GitHubUser>): Single<List<GitHubUser>>
    fun retain(user: GitHubUser): Single<GitHubUser>

}