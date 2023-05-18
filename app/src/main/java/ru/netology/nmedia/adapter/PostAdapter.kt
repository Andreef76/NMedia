package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.utils.NumberConverter

typealias LikeCallback = (Post) -> Unit //Вот этот метод
typealias ShareCallback = (Post) -> Unit
typealias ViewCallback = (Post) -> Unit

class PostAdapter( // Теперь помимо метода для лайков нам нужно передать ссылку на метод для репостов
    private val likeCallback : LikeCallback,
    private val shareCallback: ShareCallback, //пока понятно? да
    private val viewCallback : ViewCallback
    ) : ListAdapter<Post, PostViewHolder>(PostDiffCallback) {
// он приходит в post adapter из mainActivity
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view, likeCallback, shareCallback, viewCallback)

    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

}

class PostViewHolder(
    private val binding: CardPostBinding,
    private val likeCallback : LikeCallback,
    private val shareCallback: ShareCallback,
    private val viewCallback: ViewCallback
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(post: Post) {
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likeCount.text = NumberConverter.convertCount(post.likes)
            shareCount.text = NumberConverter.convertCount(post.shareCount)
            viewsCount.text = NumberConverter.convertCount(post.viewsCount)

            like.setImageResource(if (post.likedByMe) R.drawable.ic_baseline_favorite_red_24 else R.drawable.ic_baseline_favorite_border_24)

            like.setOnClickListener {
                likeCallback(post)
            }

            share.setOnClickListener {
                shareCallback(post)
            }

            removeRedEye.setOnClickListener {
                viewCallback(post)
            }

        }
    }

}

object PostDiffCallback : DiffUtil.ItemCallback<Post> () {

    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem

}
