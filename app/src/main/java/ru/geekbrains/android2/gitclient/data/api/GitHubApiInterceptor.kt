package ru.geekbrains.android2.gitclient.data.api

import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import ru.geekbrains.android2.gitclient.BuildConfig.GITHUB_USER_NAME
import ru.geekbrains.android2.gitclient.BuildConfig.GITHUB_USER_PASSWORD

object GitHubApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .header("Authorization", Credentials.basic(GITHUB_USER_NAME, GITHUB_USER_PASSWORD))
                .build()
        )

}