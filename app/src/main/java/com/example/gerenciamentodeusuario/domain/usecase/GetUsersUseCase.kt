package com.example.gerenciamentodeusuario.domain.usecase

import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository) {
    operator fun invoke(): Flow<List<User>> {
        return repository.getUsers()
    }
}