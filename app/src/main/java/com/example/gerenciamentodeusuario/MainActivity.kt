package com.example.gerenciamentodeusuario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gerenciamentodeusuario.presentation.navigation.AppNavHost
import com.example.gerenciamentodeusuario.ui.theme.GerenciamentoDeUsuarioTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GerenciamentoDeUsuarioTheme {
                AppNavHost()
            }
        }
    }
}