package com.example.gerenciamentodeusuario.data.repository

import com.example.gerenciamentodeusuario.data.dao.UserDao
import com.example.gerenciamentodeusuario.data.local.entity.toEntity
import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override fun getUsers(): Flow<List<User>> =
        userDao.getAll().map { list -> list.map { it.toDomain() } }

    override suspend fun getUserById(id: Int): User? =
        userDao.getById(id)?.toDomain()

    override suspend fun addUser(user: User) {
        userDao.insert(user.toEntity())
    }

    override suspend fun updateUser(user: User) {
        userDao.update(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        userDao.delete(user.toEntity())
    }
}