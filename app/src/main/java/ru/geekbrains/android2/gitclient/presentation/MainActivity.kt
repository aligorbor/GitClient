package ru.geekbrains.android2.gitclient.presentation

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.geekbrains.android2.gitclient.R
import ru.geekbrains.android2.gitclient.databinding.ActivityMainBinding
import ru.geekbrains.android2.gitclient.presentation.abs.AbsActivity
import ru.geekbrains.android2.gitclient.presentation.users.UsersScreen
import javax.inject.Inject

class MainActivity : AbsActivity() {
    val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    private var vb: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)

        savedInstanceState ?: router.newRootScreen(UsersScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}