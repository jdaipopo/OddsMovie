package com.odds.movie.login

import com.odds.movie.data.SharePreferenceLocalStorage
import kotlinx.coroutines.*
import java.time.Duration

class LoginPresenter constructor(
    private val dispatcher: CoroutineDispatcher,
    private val duration: Long,
    private val localStorage: SharePreferenceLocalStorage

    ) {


        //loose coupling, hight
        private lateinit var view:  LoginView
        private val scope = CoroutineScope(Job() + dispatcher)

        fun attachView(view: LoginView) {
            this.view = view
        }

    interface LoginView {
        fun goToMovieScreen(user: User)
        fun showToastMessage()
        fun showProgressBar()
        fun hideProgressBar()
    }

    fun login(username: String, password: String) {
        scope.launch {
            view.showProgressBar()
            delay(duration)

        if (username == "admin" && password == "admin") {
            val user = User(username, password)
            localStorage.insert(username)
            view.goToMovieScreen(user)
        } else {
            view.showToastMessage()
        }
        view.showProgressBar()
        }
    }
}