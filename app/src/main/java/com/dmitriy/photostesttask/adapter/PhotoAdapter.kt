package com.dmitriy.photostesttask.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dmitriy.photostesttask.core_network.source.photos.entities.GetPhotosResponseEntityItem
import com.dmitriy.photostesttask.databinding.ItemListUsersBinding

class PhotoAdapter(
    private val listener: (String) -> (Unit)
) : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    class PhotoViewHolder(val binding: ItemListUsersBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<GetPhotosResponseEntityItem>() {
        override fun areItemsTheSame(
            oldItem: GetPhotosResponseEntityItem,
            newItem: GetPhotosResponseEntityItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GetPhotosResponseEntityItem,
            newItem: GetPhotosResponseEntityItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    val diffAsync = AsyncListDiffer<GetPhotosResponseEntityItem>(this, diffCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            ItemListUsersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = diffAsync.currentList[position]

        holder.binding.apply {
            userTextView.text = "${item.user.first_name} ${item.user.last_name}"

            Glide.with(holder.binding.root.context)
                .load(item.user.profile_image.large)
                .centerCrop()
                .into(userImageView)

            userImageView.setOnClickListener {
                listener.invoke(item.user.profile_image.large)
            }
        }
    }

    override fun getItemCount(): Int = diffAsync.currentList.size
}