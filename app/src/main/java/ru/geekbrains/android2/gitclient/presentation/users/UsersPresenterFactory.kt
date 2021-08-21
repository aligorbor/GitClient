package ru.geekbrains.android2.gitclient.presentation.users

import dagger.assisted.AssistedFactory

@AssistedFactory
interface UsersPresenterFactory {
    fun create(): UsersPresenter
}