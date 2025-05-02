package com.example.gerenciamentodeusuario.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gerenciamentodeusuario.domain.model.User


@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val email: String,
    val age: Int
) {
    fun toDomain(): User = User(id, name, email, age)
}

fun User.toEntity(): UserEntity = UserEntity(id, name, email, age)