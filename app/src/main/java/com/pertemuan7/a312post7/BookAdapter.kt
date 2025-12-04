package com.pertemuan7.a312post7

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pertemuan7.a312post7.databinding.ItemBookBinding

class BookAdapter(private var list: List<Book>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemBookBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.tvCardTitle.text = book.title
            binding.tvCardRelease.text = book.releaseDate

            Glide.with(binding.root)
                .load(book.cover)
                .into(binding.ivCover)

            binding.root.setOnClickListener {
                val intent = Intent(binding.root.context, BookDetail::class.java).apply {
                    putExtra("title", book.title)
                    putExtra("releaseDate", book.releaseDate)
                    putExtra("description", book.description)
                    putExtra("pages", book.pages)
                    putExtra("cover", book.cover)
                }
                binding.root.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemBookBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}
