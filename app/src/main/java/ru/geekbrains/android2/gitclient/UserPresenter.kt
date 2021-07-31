package ru.geekbrains.android2.gitclient

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class UserPresenter(val router: Router, val textLogin: String) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setLogin(textLogin)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}