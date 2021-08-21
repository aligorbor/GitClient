package ru.geekbrains.android2.gitclient.data.di.modules

import dagger.Binds
import dagger.Module
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepository
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepositoryImpl
import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserDataSource
import ru.geekbrains.android2.gitclient.data.user.datasource.CacheUserDataSourceImpl
import ru.geekbrains.android2.gitclient.data.user.datasource.CloudUserDataSource
import ru.geekbrains.android2.gitclient.data.user.datasource.UserDataSource
import javax.inject.Singleton

@Module
interface UsersModule {
    @Singleton
    @Binds
    fun bindGitHubUserRepository(repository: GitHubUserRepositoryImpl): GitHubUserRepository

    @Singleton
    @Binds
    fun bindUserDataSource(dataSource: CloudUserDataSource): UserDataSource

    @Singleton
    @Binds
    fun bindCacheUserDataSource(dataSource: CacheUserDataSourceImpl): CacheUserDataSource
}