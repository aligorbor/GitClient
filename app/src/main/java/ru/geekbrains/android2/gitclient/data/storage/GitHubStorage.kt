package ru.geekbrains.android2.gitclient.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.geekbrains.android2.gitclient.data.storage.user.GitHubUserDao
import ru.geekbrains.android2.gitclient.data.user.GitHubUser
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepos

@Database(exportSchema = false, entities = [GitHubUser::class, GitHubUserRepos::class], version = 2)
abstract class GitHubStorage : RoomDatabase() {

    abstract fun gitHubUserDao(): GitHubUserDao

}

