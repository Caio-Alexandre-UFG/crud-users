package com.example.gerenciamentodeusuario.presentation.navigation

sealed class Routes(val route: String) {
    object UserList : Routes("user_list")
    object UserForm : Routes("user_form?userId={userId}") {
        fun createRoute(userId: Int? = null): String {
            return if (userId != null) "user_form?userId=$userId" else "user_form"
        }
    }
}