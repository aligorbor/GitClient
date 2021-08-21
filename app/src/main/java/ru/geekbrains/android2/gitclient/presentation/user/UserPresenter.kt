package ru.geekbrains.android2.gitclient.presentation.user

import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.plusAssign
import moxy.MvpPresenter
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepository
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel
import ru.geekbrains.android2.gitclient.presentation.repos.ReposScreen
import ru.geekbrains.android2.gitclient.scheduler.Schedulers

class UserPresenter @AssistedInject constructor(
    private val router: Router,
    @Assisted("login") private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val schedulers: Schedulers
) : MvpPresenter<UserView>() {
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        disposable +=
            userRepository
                .getUserByLogin(userLogin)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    {
                        viewState.setLogin(it.login.uppercase(), it.reposUrl)
                        viewState.setAvatar(it.avatar)
                    },
                    viewState::showError
                )
    }

    fun setRepos(reposUrl: String) {
        disposable += userRepository
            .getUserRepositories(reposUrl)
            .observeOn(schedulers.background())
            .map { repos -> repos.map(GitHubUserReposViewModel.Mapper::map) }
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                viewState::showRepos,
                viewState::showError
            )
    }

    fun displayRepos(repos: GitHubUserReposViewModel) {
        router.navigateTo(ReposScreen(repos))
    }

    override fun onDestroy() {
        disposable.clear()
    }

}