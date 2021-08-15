package ru.geekbrains.android2.gitclient.data.user.datasource

import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.user.GitHubUser

class CacheUserDataSourceImpl : CacheUserDataSource {

    private val cache = mutableListOf<GitHubUser>()

    override fun getUsers(): Single<List<GitHubUser>> =
        Single.just(cache)

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.firstOrNull { user -> user.login.contentEquals(userId, ignoreCase = true) }
            ?.let { user -> Maybe.just(user) }
            ?: Maybe.empty()

    override fun retain(users: List<GitHubUser>): Single<List<GitHubUser>> =
        Single.fromCallable {
            cache.clear()
            cache.addAll(users)
            cache
        }

    override fun retain(user: GitHubUser): Single<GitHubUser> =
        Single.fromCallable { user }

}