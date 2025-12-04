package com.pertemuan7.a312post7

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.pertemuan7.a312post7.databinding.ActivityDetailBinding

class BookDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBarDetail.title = "Detail Buku"
        binding.topAppBarDetail.setNavigationOnClickListener {
            finish()
        }

        val title = intent.getStringExtra("title")
        val releaseDate = intent.getStringExtra("releaseDate")
        val description = intent.getStringExtra("description")
        val pages = intent.getIntExtra("pages", 0)
        val cover = intent.getStringExtra("cover")

        Glide.with(this)
            .load(cover)
            .into(binding.ivCoverDetail)

        binding.tvTitleDetail.text = title
        binding.tvSubtitleDetail.text = title
        binding.tvReleaseDetail.text = releaseDate
        binding.tvDescriptionDetail.text = description
        binding.tvPagesDetail.text = "Pages: $pages"
    }
}
