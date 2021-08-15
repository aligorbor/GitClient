package ru.geekbrains.android2.gitclient.data.user.datasource

object CacheUserReposDataSourceFactory {
    fun create(): CacheUserReposDataSource = CacheUserReposDataSourceImpl()
}