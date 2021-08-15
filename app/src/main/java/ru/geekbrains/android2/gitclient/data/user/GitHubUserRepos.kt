package ru.geekbrains.android2.gitclient.data.user

import com.google.gson.annotations.SerializedName

data class GitHubUserRepos(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("forks_count") val forksCount: String?
)
