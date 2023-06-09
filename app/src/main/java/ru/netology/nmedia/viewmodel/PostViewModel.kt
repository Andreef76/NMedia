package ru.netology.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryMemoryImpl

class PostViewModel : ViewModel() {
    private val repository : PostRepository = PostRepositoryMemoryImpl()
    val data = repository.getAll()
    fun likeById(id: Long) { return repository.likeById(id) }
    fun share(id: Long) = repository.share(id)
    fun removeRedEye(id: Long) = repository.removeRedEye(id)

}
