package ru.geekbrains.android2.gitclient.data.di

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.geekbrains.android2.gitclient.App
import ru.geekbrains.android2.gitclient.data.di.modules.ApiModule
import ru.geekbrains.android2.gitclient.data.di.modules.StorageModule
import ru.geekbrains.android2.gitclient.data.di.modules.UIModule
import ru.geekbrains.android2.gitclient.data.di.modules.UsersModule
import ru.geekbrains.android2.gitclient.scheduler.Schedulers
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        UIModule::class,
        UsersModule::class,
        ApiModule::class,
        StorageModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent

    }

}