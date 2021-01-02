package com.demo.assignment.listing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.demo.assignment.R
import com.demo.assignment.data.model.list.ReposListingItem
import com.demo.assignment.databinding.ItemRepoNewBinding
import com.demo.assignment.listing.viewholder.RepoViewHolder
import com.demo.assignment.utils.callbacks.IItemClickCallback

class ReposListAdapter(
    private var list: List<ReposListingItem?>,
    private val itemClick: IItemClickCallback<ReposListingItem?>
) :
    RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemRepoNewBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {

        val data = list[position]
        data?.let { repo ->

            holder.apply {
                onBind(repo) {
                    itemClick.onItemClick(repo)
                }
            }
        }


        holder.itemView.apply {
           startAnimation(AnimationUtils.loadAnimation(context,R.anim.item_down_to_up))
        }


    }

    override fun getItemCount() = list.size

    fun updateData(newsList: List<ReposListingItem?>) {

        val oldCount = list.size.run {

            if (this > 0) this-1 else 0

        }

        list += newsList

        val newCount  = list.size

        notifyItemRangeChanged(oldCount, newCount)
    }
}