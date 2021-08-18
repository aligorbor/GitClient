package ru.geekbrains.android2.gitclient.scheduler

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers.newThread


class DefaultSchedulers : Schedulers {

    override fun background(): Scheduler = newThread()

    override fun main(): Scheduler = mainThread()
}