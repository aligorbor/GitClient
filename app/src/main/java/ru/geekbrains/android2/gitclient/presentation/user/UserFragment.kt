package ru.geekbrains.android2.gitclient.presentation.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.gitclient.R.layout.fragment_user
import ru.geekbrains.android2.gitclient.arguments
import ru.geekbrains.android2.gitclient.databinding.FragmentUserBinding
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel
import ru.geekbrains.android2.gitclient.presentation.abs.AbsFragment
import ru.geekbrains.android2.gitclient.presentation.user.adapter.UserReposAdapter
import ru.geekbrains.android2.gitclient.setStartDrawableCircleImageFromUri
import javax.inject.Inject

class UserFragment : AbsFragment(fragment_user), UserView,
    UserReposAdapter.DelegateRepos {
    companion object Factory {
        private const val ARG_USER_LOGIN = "arg_user_login"
        fun newInstance(textLogin: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to textLogin)
    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Inject
    lateinit var presenterFactory: UserPresenterFactory

    private val vb: FragmentUserBinding by viewBinding()

    private val presenter: UserPresenter by moxyPresenter {
        presenterFactory.create(userLogin)
    }

    private val reposAdapter = UserReposAdapter(delegate = this)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vb.rvUserRepos.adapter = reposAdapter
    }

    override fun setLogin(text: String, reposUrl: String) {
        vb.tvLoginUser.text = text
        presenter.setRepos(reposUrl)
    }

    override fun setAvatar(text: String) {
        vb.tvLoginUser.setStartDrawableCircleImageFromUri(text)
    }

    override fun showRepos(repos: List<GitHubUserReposViewModel>) {
        reposAdapter.submitList(repos)
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_LONG).show()
    }

    override fun onReposPicked(repos: GitHubUserReposViewModel) =
        presenter.displayRepos(repos)
}