package com.example.gerenciamentodeusuario.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gerenciamentodeusuario.data.dao.UserDao
import com.example.gerenciamentodeusuario.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}