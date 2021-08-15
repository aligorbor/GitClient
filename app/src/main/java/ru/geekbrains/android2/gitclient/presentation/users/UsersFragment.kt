package ru.geekbrains.android2.gitclient.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.gitclient.App
import ru.geekbrains.android2.gitclient.data.user.GitHubUserRepositoryFactory
import ru.geekbrains.android2.gitclient.databinding.FragmentUsersBinding
import ru.geekbrains.android2.gitclient.presentation.AndroidScreens
import ru.geekbrains.android2.gitclient.presentation.BackButtonListener
import ru.geekbrains.android2.gitclient.presentation.users.adapter.UsersRVAdapter
import ru.geekbrains.android2.gitclient.scheduler.SchedulersFactory

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GitHubUserRepositoryFactory.create(),
            App.instance.router,
            AndroidScreens(),
            SchedulersFactory.create()
        )
    }
    var adapter: UsersRVAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun backPressed() = presenter.backPressed()
}