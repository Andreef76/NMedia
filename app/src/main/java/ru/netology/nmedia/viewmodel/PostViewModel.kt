package ru.netology.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryMemoryImpl

class PostViewModel : ViewModel() {
    private val repository : PostRepository = PostRepositoryMemoryImpl()
    val data = repository.get()
    fun like() = repository.like()
    fun share() = repository.share()
//    fun removeRedEye() = repository.removeRedEye()

}