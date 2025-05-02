package com.example.gerenciamentodeusuario.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gerenciamentodeusuario.domain.model.User
import com.example.gerenciamentodeusuario.domain.usecase.AddUserUseCase
import com.example.gerenciamentodeusuario.domain.usecase.GetUserByIdUseCase
import com.example.gerenciamentodeusuario.domain.usecase.UpdateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserFormViewModel @Inject constructor(
    private val addUserUseCase: AddUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    fun loadUser(id: Int) {
        viewModelScope.launch {
            val result = getUserByIdUseCase(id)
            _user.value = result
        }
    }

    fun saveUser(name: String, email: String, age: Int) {
        viewModelScope.launch {
            val existing = _user.value
            val user = User(id = existing?.id ?: 0, name = name, email = email, age = age)
            if (existing == null) {
                addUserUseCase(user)
            } else {
                updateUserUseCase(user)
            }
        }
    }
}