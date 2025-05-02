package com.example.gerenciamentodeusuario.di

import android.content.Context
import androidx.room.Room
import com.example.gerenciamentodeusuario.data.AppDatabase
import com.example.gerenciamentodeusuario.data.dao.UserDao
import com.example.gerenciamentodeusuario.data.repository.UserRepositoryImpl
import com.example.gerenciamentodeusuario.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository
}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "users.db"
    ).build()

    @Provides
    @Singleton
    fun provideUserDao(
        db: AppDatabase
    ): UserDao = db.userDao()
}
