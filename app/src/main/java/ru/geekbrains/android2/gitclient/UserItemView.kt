package ru.geekbrains.android2.gitclient

interface UserItemView : IItemView {
    fun setLogin(text: String)
    fun getLogin(): String
}