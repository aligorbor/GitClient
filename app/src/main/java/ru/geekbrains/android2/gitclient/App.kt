package ru.geekbrains.android2.gitclient

import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import ru.geekbrains.android2.gitclient.data.di.DaggerApplicationComponent
import ru.geekbrains.android2.gitclient.scheduler.DefaultSchedulers


class App : DaggerApplication() {
    companion object {
        lateinit var instance: App
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler { }
        instance = this
    }

}