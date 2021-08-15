package ru.geekbrains.android2.gitclient.presentation.repos

import moxy.MvpPresenter
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel

class ReposPresenter(private val repos: GitHubUserReposViewModel?) : MvpPresenter<ReposView>() {

    override fun onFirstViewAttach() {
        repos?.let { viewState.showRepos(repos) }
    }

}