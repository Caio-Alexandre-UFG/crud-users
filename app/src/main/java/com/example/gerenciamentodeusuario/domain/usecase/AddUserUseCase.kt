package com.example.gerenciamentodeusuario.domain.usecase

import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import javax.inject.Inject

class AddUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(user: User) {
        userRepository.addUser(user)
    }
}