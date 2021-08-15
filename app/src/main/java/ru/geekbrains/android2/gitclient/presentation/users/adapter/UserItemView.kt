package ru.geekbrains.android2.gitclient.presentation.users.adapter

interface UserItemView : IItemView {
    fun setLogin(text: String)
    fun setAvatar(text: String)
}