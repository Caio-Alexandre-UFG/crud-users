package com.example.gerenciamentodeusuario.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserFormScreen(
    viewModel: UserFormViewModel,
    userId: Int?, // null for new user
    onSave: () -> Unit
) {
    val user by viewModel.user.collectAsState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    LaunchedEffect(userId) {
        userId?.let {
            viewModel.loadUser(it)
        }
    }

    LaunchedEffect(user) {
        user?.let {
            name = it.name
            email = it.email
            age = it.age.toString()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(if (userId == null) "Novo Usuário" else "Editar Usuário") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val parsedAge = age.toIntOrNull() ?: 0
                viewModel.saveUser(name, email, parsedAge)
                onSave()
            }) {
                Icon(Icons.Default.Done, contentDescription = "Salvar")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nome") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Idade") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}