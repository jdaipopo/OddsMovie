package com.odds.movie.login

import kotlinx.coroutines.Dispatchers
import org.junit.Assert.*
import org.junit.Test

class LoginPresenterTest {

    @Test
    fun `when input username and password correct should call goToMovieScreen`() {
        // AAA = Arrange, Act, Assert
        // Arrange = Given a context, prepare environment or object
        val presenter = LoginPresenter(Dispatchers.Unconfined, 0)
        val view = SpyLoginView()
        presenter.attachView(view)


        // Act = Action, Behavior
        presenter.login("admin","admin")
        // Assert = Verify the result
        // Test Double = Spy, Mock, Dummy, Fake, Stub
        // Mock, Stub
        // I use Spy

        val expect = 1
        val expectShowToastMessage = 0
        assertEquals(expect, view.spyGoToMovieScreen)
        assertEquals(expectShowToastMessage, view.spyShowToastMessage)

    }

    @Test
    fun `when input username and password wrong should call showToastMessage`() {
        //Arrange
        val presenter = LoginPresenter(Dispatchers.Unconfined,0)
        val view = SpyLoginView()
        presenter.attachView(view)
        //Act
        presenter.login("not admin","not admin")

        val expect = 1
        assertEquals(expect, view.spyShowToastMessage)
    }

    class SpyLoginView: LoginPresenter.LoginView {

        var spyGoToMovieScreen = 0
        var spyShowToastMessage = 0

        override fun goToMovieScreen(user: User) {
            spyGoToMovieScreen += 1
        }

        override fun showToastMessage() {
            spyShowToastMessage += 1
        }

        override fun showProgressBar() {

        }

        override fun hideProgressBar() {

        }

    }
}