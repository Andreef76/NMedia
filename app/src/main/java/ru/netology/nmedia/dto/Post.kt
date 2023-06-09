package ru.netology.nmedia.dto

data class Post (
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likedByMe: Boolean,
    val likes: Int,
    val shareCount: Int,
    val viewsCount: Int
)
