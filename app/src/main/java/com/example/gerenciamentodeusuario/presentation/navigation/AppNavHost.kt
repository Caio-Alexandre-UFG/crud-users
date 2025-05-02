package com.example.gerenciamentodeusuario.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gerenciamentodeusuario.presentation.UserFormScreen
import com.example.gerenciamentodeusuario.presentation.UserFormViewModel
import com.example.gerenciamentodeusuario.presentation.UserListScreen
import com.example.gerenciamentodeusuario.presentation.UserListViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.UserList.route
    ) {
        composable(Routes.UserList.route) {
            val userListViewModel: UserListViewModel = hiltViewModel()
            UserListScreen(
                viewModel = userListViewModel,
                onAddUserClick = {
                    navController.navigate(Routes.UserForm.createRoute())
                },
                onEditUserClick = { user ->
                    navController.navigate(Routes.UserForm.createRoute(user.id))
                }
            )
        }

        composable(
            route = Routes.UserForm.route,
            arguments = listOf(navArgument("userId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) { backStackEntry ->
            val userFormViewModel: UserFormViewModel = hiltViewModel()
            val userId = backStackEntry.arguments?.getInt("userId")?.takeIf { it != -1 }

            UserFormScreen(
                viewModel = userFormViewModel,
                userId = userId,
                onSave = {
                    navController.popBackStack()
                }
            )
        }
    }
}