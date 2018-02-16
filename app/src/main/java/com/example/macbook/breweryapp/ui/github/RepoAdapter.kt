package com.example.macbook.breweryapp.ui.github

import android.arch.paging.PagedListAdapter
import android.support.v7.recyclerview.extensions.DiffCallback
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.macbook.breweryapp.R
import com.example.macbook.breweryapp.model.NetworkState
import com.example.macbook.breweryapp.model.Repo
import kotlinx.android.synthetic.main.repo_item.view.*

class RepoAdapter : PagedListAdapter<Repo, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    private var networkState: NetworkState? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
            when (viewType) {
                R.layout.repo_item -> RepoViewHolder(parent)
                R.layout.progress_item -> ProgressViewHolder(parent)
                else -> throw IllegalArgumentException("unknow view type")
            }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.repo_item -> (holder as RepoViewHolder).bind(getItem(position))
            R.layout.progress_item -> (holder as ProgressViewHolder).bind(networkState)
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.progress_item
        } else {
            R.layout.repo_item
        }
    }

    fun setNetworkState(newNetWorkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetWorkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemChanged(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetWorkState) {
            notifyItemChanged(itemCount - 1)
        }
    }

    class RepoViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.repo_item, parent, false)) {

        fun bind(repo: Repo?) {
            repo?.apply {
                itemView.tv_repo_name.text = this.fullname
            }
        }
    }

    class ProgressViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.progress_item, parent, false)) {

        fun bind(networkState: NetworkState?) {

        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                    oldItem == newItem
        }
    }
}