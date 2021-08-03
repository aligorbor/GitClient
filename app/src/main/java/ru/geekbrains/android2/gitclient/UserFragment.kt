package ru.geekbrains.android2.gitclient

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.android2.gitclient.databinding.FragmentUserBinding

class UserFragment(val textLogin: String="") : MvpAppCompatFragment(), UserView, BackButtonListener {
    companion object {
        fun newInstance(textLogin: String) = UserFragment(textLogin)
    }

    private var vb: FragmentUserBinding? = null
    val presenter: UserPresenter by moxyPresenter {
        UserPresenter(App.instance.router,textLogin)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding.inflate(inflater, container, false).also {
        vb = it
    }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backPressed()

    override fun setLogin(text: String) {
        vb?.tvLoginUser?.text = text
    }

}