package ru.geekbrains.android2.gitclient.data.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.geekbrains.android2.gitclient.data.di.InMemory
import ru.geekbrains.android2.gitclient.data.di.Persisted
import ru.geekbrains.android2.gitclient.data.storage.GitHubStorage
import ru.geekbrains.android2.gitclient.data.storage.migration.GitHub1to2Migration

@Module
class StorageModule {

    @Persisted
    @Provides
    fun provideGitHubDatabaseStorage(context: Context): GitHubStorage =
        Room.databaseBuilder(context, GitHubStorage::class.java, "github.db")
            .addMigrations(GitHub1to2Migration)
            //        .fallbackToDestructiveMigration()
            .build()

    @InMemory
    @Provides
    fun provideGitHubInMemoryStorage(context: Context): GitHubStorage =
        Room.inMemoryDatabaseBuilder(context, GitHubStorage::class.java)
            .fallbackToDestructiveMigration()
            .build()
}