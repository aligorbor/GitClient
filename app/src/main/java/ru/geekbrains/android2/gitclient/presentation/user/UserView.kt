package ru.geekbrains.android2.gitclient.presentation.user

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel
import ru.geekbrains.android2.gitclient.presentation.ScreenView

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView : ScreenView {
    fun setLogin(text: String, reposUrl: String)
    fun setAvatar(text: String)
    fun showRepos(repos: List<GitHubUserReposViewModel>)
}