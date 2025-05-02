package com.example.gerenciamentodeusuario.domain.model

data class User(
    val id: Int = 0,
    val name: String,
    val email: String,
    val age: Int
)