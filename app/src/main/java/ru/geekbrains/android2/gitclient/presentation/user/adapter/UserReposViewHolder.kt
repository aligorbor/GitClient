package ru.geekbrains.android2.gitclient.presentation.user.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.geekbrains.android2.gitclient.click
import ru.geekbrains.android2.gitclient.databinding.ItemReposBinding
import ru.geekbrains.android2.gitclient.presentation.GitHubUserReposViewModel

class UserReposViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val viewBinding: ItemReposBinding by viewBinding()

    fun bind(repos: GitHubUserReposViewModel, delegate: UserReposAdapter.DelegateRepos?) {
        with(viewBinding) {
            userRepository.text = repos.name

            root.click { delegate?.onReposPicked(repos) }
        }
    }

}