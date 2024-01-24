package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.domain

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.dao.UserInfoDao
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.vm.LoginViewModel
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.HomeScreen
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class LoginViewModelTest {

    private val userInfoDao = mock<UserInfoDao>()
    private val appContext = mock<Context>()
    private val navController = mock<NavHostController>()
    private val viewModel = LoginViewModel(userInfoDao, appContext)

    @Test
    fun checkValidInput_withEmptyFields_showsToast() = runBlocking {
        viewModel.checkValidInput("", "", navController)
        verify { Toast.makeText(appContext, "Please Fill the Info", Toast.LENGTH_LONG).show() }
    }

    @Test
    fun checkValidInput_withNonExistentUser_showsToast() = runBlocking {
        //every { userInfoDao.fetchByPhone("1234567890") } returns null
        viewModel.checkValidInput("1234567890", "1234", navController)
        verify { Toast.makeText(appContext, "User Not Found", Toast.LENGTH_LONG).show() }
    }

    @Test
    fun checkValidInput_withWrongPin_showsToast() = runBlocking {
        //val user = User(phone = "1234567890", pin = "12345")
        //every { userInfoDao.fetchByPhone("1234567890") } returns user
        viewModel.checkValidInput("1234567890", "1234", navController)
        verify { Toast.makeText(appContext, "Password Not Matched", Toast.LENGTH_LONG).show() }
    }

    @Test
    fun checkValidInput_withCorrectCredentials_navigatesToHomeScreen() = runBlocking {
        //val user = User(phone = "1234567890", pin = "1234")
        //every { userInfoDao.fetchByPhone("1234567890") } returns user
        viewModel.checkValidInput("1234567890", "1234", navController)
        verify { navController.navigate(HomeScreen.route) }
    }

    @Test
    fun isValidMobile_withValidNumber_returnsTrue() {
        assertEquals(true, viewModel.isValidMobile("01700000000"))
        //assertTrue(viewModel.isValidMobile("1234567890"))
    }

    @Test
    fun isValidMobile_withInvalidNumber_returnsFalse() {
        assertFalse(viewModel.isValidMobile("1234"))
    }

    @Test
    fun isValidEmail_withValidEmail_returnsTrue() {
        assertTrue(viewModel.isValidEmail("test@example.com"))
    }

    @Test
    fun isValidEmail_withInvalidEmail_returnsFalse() {
        assertFalse(viewModel.isValidEmail("test"))
    }

    @Test
    fun isValidMobile() {
    }

    @Test
    fun isValidEmail() {
    }
}