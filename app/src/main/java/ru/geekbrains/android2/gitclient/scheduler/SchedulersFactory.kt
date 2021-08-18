package ru.geekbrains.android2.gitclient.scheduler

object SchedulersFactory {
    fun create(): Schedulers = DefaultSchedulers()
}