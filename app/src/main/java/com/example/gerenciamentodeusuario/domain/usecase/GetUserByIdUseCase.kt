package com.example.gerenciamentodeusuario.domain.usecase

import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val repository: UserRepository) {
    suspend operator fun invoke(id: Int): User? {
        return repository.getUserById(id)
    }
}