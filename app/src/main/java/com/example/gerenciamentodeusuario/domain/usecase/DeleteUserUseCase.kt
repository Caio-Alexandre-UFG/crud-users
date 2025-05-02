package com.example.gerenciamentodeusuario.domain.usecase

import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val repository: UserRepository) {
    suspend operator fun invoke(user: User) {
        repository.deleteUser(user)
    }
}