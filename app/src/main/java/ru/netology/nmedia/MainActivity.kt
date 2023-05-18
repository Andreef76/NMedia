package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.viewModels
import ru.netology.nmedia.adapter.PostAdapter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.utils.NumberConverter.convertCount
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

// ==========================================================================================
//
//        binding.root.setOnClickListener  {
//            Toast.makeText(this,"Root is clicked",Toast.LENGTH_SHORT).show()
//        }
//
//        binding.avatar.setOnClickListener {
//            Toast.makeText(this,"Avatar is clicked",Toast.LENGTH_SHORT).show()
//        }
// ==========================================================================================

        val viewModel: PostViewModel by viewModels()
        val adapter = PostAdapter (
            { viewModel.likeById(it.id) },
            { viewModel.share(it.id) },
            { viewModel.removeRedEye(it.id) }
        )
        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }
    }
}
