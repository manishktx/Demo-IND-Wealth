package com.demo.assignment.listing.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.databinding.ItemRepoNewBinding

class RepoViewHolder(private val binding: ItemRepoNewBinding) : RecyclerView.ViewHolder(binding.root) {

   fun onBind(repo : ReposListingItem, itemClick: View.OnClickListener)
   {

       binding.apply {
           this.item = repo
           clickListener = itemClick
           executePendingBindings()
       }
   }
}