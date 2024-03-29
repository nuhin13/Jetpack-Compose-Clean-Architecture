package com.nuhin13.cleanarchitecturewithjetpackcompose.feature.authentication.login.vm

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.nuhin13.cleanarchitecturewithjetpackcompose.feature.navigation.HomeScreen
import com.nuhin13.domain.entities.Password
import com.nuhin13.domain.entities.PhoneNumber
import com.nuhin13.domain.feature.authentication.entity.LoginReq
import com.nuhin13.domain.feature.authentication.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val  loginUseCase: LoginUseCase,
    @ApplicationContext private val appContext: Context
) : ViewModel() {

    fun checkUserLoggedInOrNot(navController: NavHostController) {
//        viewModelScope.launch {
//            if (loginUseCase.checkLoginSession())
//                navController.navigate(HomeScreen.route)
//        }
    }

    fun checkValidInput(
        phone: String, pin: String, navController: NavHostController) {

        if (phone.isEmpty() || pin.isEmpty()) {
            Toast.makeText(appContext, "Please Fill the Info", Toast.LENGTH_LONG).show()
            return
        }

        viewModelScope.launch {
            val login = loginUseCase.doLogin(
                LoginReq(
                    phoneNumber = PhoneNumber(number = phone),
                    password = Password(password = pin)
                )
            )

            if (login != "Success") {
                Toast.makeText(appContext, login, Toast.LENGTH_LONG).show()
            } else {
                navController.navigate(HomeScreen.route)
            }
        }
    }

    fun validity() {
        if (isValidMobile("01700000000")) {
            Toast.makeText(appContext, "Valid Mobile", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(appContext, "Invalid Mobile", Toast.LENGTH_LONG).show()
        }

        if (isValidEmail("fff")) {
            Toast.makeText(appContext, "Valid Email", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(appContext, "Invalid Email", Toast.LENGTH_LONG).show()
        }
    }

    // mobile validation
    fun isValidMobile(phone: String): Boolean {
        return android.util.Patterns.PHONE.matcher(phone).matches()
    }

    // email validation
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}