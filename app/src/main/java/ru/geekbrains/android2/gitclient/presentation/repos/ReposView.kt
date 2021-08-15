package ru.geekbrains.android2.gitclient.presentation.repos

import moxy.viewstate.strategy.alias.SingleState
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel
import ru.geekbrains.android2.gitclient.presentation.ScreenView

interface ReposView : ScreenView {

    @SingleState
    fun showRepos(repos: GitHubUserReposViewModel)

}