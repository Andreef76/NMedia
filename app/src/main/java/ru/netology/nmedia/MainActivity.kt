package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.utils.NumberConverter.convertCount
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// ==========================================================================================

//        binding.root.setOnClickListener  {
//            Toast.makeText(this,"Root is clicked",Toast.LENGTH_SHORT).show()
//        }
//
//        binding.avatar.setOnClickListener {
//            Toast.makeText(this,"Avatar is clicked",Toast.LENGTH_SHORT).show()
//        }
// ==========================================================================================

        val viewModel by viewModels<PostViewModel>()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likeCount.text = convertCount(post.likes)
                shareCount.text = convertCount(post.shareCount)
                viewsCount.text = convertCount(post.viewsCount)

                like.setImageResource(if (post.likedByMe) R.drawable.ic_baseline_favorite_red_24 else R.drawable.ic_baseline_favorite_border_24)

                likeCount.text = convertCount(post.likes)
            }
        }

        binding.like.setOnClickListener {
            viewModel.like()

        }

        binding.share.setOnClickListener {
            viewModel.share()
        }

//        binding.removeRedEye.setOnClickListener {
//            viewModel.removeRedEye()
//        }

    }


}
