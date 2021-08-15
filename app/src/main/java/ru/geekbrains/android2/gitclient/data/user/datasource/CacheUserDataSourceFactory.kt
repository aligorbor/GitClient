package ru.geekbrains.android2.gitclient.data.user.datasource

object CacheUserDataSourceFactory {
    fun create(): CacheUserDataSource = CacheUserDataSourceImpl()
}