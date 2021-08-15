package ru.geekbrains.android2.gitclient.presentation

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun user(textLogin: String): Screen
}