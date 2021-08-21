package ru.geekbrains.android2.gitclient.presentation.repos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel

class ReposScreen(private val repos: GitHubUserReposViewModel) : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment =
        ReposFragment.newInstance(repos)

}