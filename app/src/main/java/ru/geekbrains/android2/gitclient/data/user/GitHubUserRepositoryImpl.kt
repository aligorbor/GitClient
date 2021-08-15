package ru.geekbrains.android2.gitclient.data.user


import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Observable
import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserDataSource
import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserReposDataSource
import ru.geekbrains.android2.gitclient.data.user.datasource.UserDataSource
import ru.geekbrains.android2.gitclient.data.user.datasource.UserReposDataSource

class GitHubUserRepositoryImpl(
    private val cloud: UserDataSource,
    private val cache: CacheUserDataSource,
    private val cloudRepos: UserReposDataSource,
    private val cacheRepos: CacheUserReposDataSource
) : GitHubUserRepository {

    override fun getUsers(): Observable<List<GitHubUser>> =
        Observable.merge(
            cache.getUsers().toObservable(),
            cloud.getUsers().flatMap(cache::retain).toObservable()
        )

    override fun getUserByLogin(userId: String): Maybe<GitHubUser> =
        cache.getUserByLogin(userId)
            .switchIfEmpty(cloud.getUserByLogin(userId))

    override fun getUserRepositories(reposUrl: String): Observable<List<GitHubUserRepos>> =
        Observable.merge(
            cacheRepos.getUserRepos(reposUrl).toObservable(),
            cloudRepos.getUserRepos(reposUrl).flatMap {
                cacheRepos.retain(it, reposUrl)
            }.toObservable()
        )
}