package ru.geekbrains.android2.gitclient.data.user.datasource

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepos

class CacheUserReposDataSourceImpl : CacheUserReposDataSource {
    private val cache = mutableListOf<Pair<String, List<GitHubUserRepos>>>()

    override fun retain(
        userRepos: List<GitHubUserRepos>,
        reposUrl: String
    ): Single<List<GitHubUserRepos>> = Single.fromCallable {
        cache.firstOrNull {
            it.first.contentEquals(reposUrl, ignoreCase = true)
        }?.let {
            it to userRepos
            it.second
        }
            ?: cache.add(Pair(reposUrl, userRepos))
        userRepos
    }

    override fun getUserRepos(reposUrl: String): Single<List<GitHubUserRepos>> =
        Single.fromCallable {
            cache.firstOrNull {
                it.first.contentEquals(reposUrl, ignoreCase = true)
            }?.second ?: listOf()
        }

}

