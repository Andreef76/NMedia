package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

class PostRepositoryMemoryImpl : PostRepository {

    private var post = Post (
        id = 1,
        author = "Нетология. Университет интернет-профессий будущего",
        published = "21 мая в 18:36",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        likedByMe = false,
        likes = 54,
        shareCount = 997,
        viewsCount = 5001
    )

    private val data = MutableLiveData(post)

    override fun get() = data

    override fun like() {
        post = post.copy(likedByMe = !post.likedByMe, likes = if (post.likedByMe) post.likes -1 else post.likes + 1)
        data.value = post
    }

    override fun share() {
        post = post.copy(shareCount = post.shareCount + 1)
        data.value = post
    }

//    override fun removeRedEye() {
//        post = post.copy(viewsCount =  post.viewsCount + 1)
//        data.value = post
//    }

}
