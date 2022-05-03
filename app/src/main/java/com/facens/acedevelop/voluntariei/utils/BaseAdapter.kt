package com.facens.acedevelop.voluntariei.utils

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

abstract class BaseAdapter<V : RecyclerView.ViewHolder, D> : RecyclerView.Adapter<V>() {

    private val coroutineScope = CoroutineScope(Dispatchers.Main.immediate + SupervisorJob())
    val items: MutableList<D> = mutableListOf()

    private var onClickListener: OnClickListener<D>? = null

    interface OnClickListener<D> {
        fun onClick(item: D)
    }

    override fun getItemCount(): Int = items.size

    fun set(items: Collection<D>) {
        val baseCallback = BaseDiffUtil(this.items, items.toList())

        coroutineScope.launch(Dispatchers.Default) {
            runCatching {
                DiffUtil.calculateDiff(baseCallback)
            }.onSuccess { resultDiff ->
                withContext(Dispatchers.Main) {
                    this@BaseAdapter.items.clear()
                    this@BaseAdapter.items.addAll(items)
                    resultDiff.dispatchUpdatesTo(this@BaseAdapter)
                }
            }
        }

    }

    fun add(items: Collection<D>) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    fun setOnClickListener(listener:OnClickListener<D>?) {
        onClickListener = listener
    }

    operator fun get(index: Int): D = items[index]

    protected fun callOnClick(item: D) {
        onClickListener?.onClick(item)
    }


    private class BaseDiffUtil<T>(
        old: List<T>,
        current: List<T>,
    ) : DiffUtil.Callback() {

        val oldList: List<T> = old
        val currentList: List<T> = current

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = currentList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == currentList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition] == currentList[newItemPosition]


    }

}