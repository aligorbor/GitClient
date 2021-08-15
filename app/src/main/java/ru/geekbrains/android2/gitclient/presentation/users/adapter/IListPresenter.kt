package ru.geekbrains.android2.gitclient.presentation.users.adapter

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}