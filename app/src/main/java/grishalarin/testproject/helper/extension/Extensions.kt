package grishalarin.testproject.helper.extension

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import grishalarin.localdb.model.Currency

/**
 * @author Sostavkin Grisha
 */
/**
 * DiffUtils для RecycleView
 */
fun <T> RecyclerView.Adapter<*>.autoNotify(
    oldRows: List<T>,
    newRows: List<T>,
    compare: (T, T) -> Boolean
) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldRow = oldRows[oldItemPosition]
            val newRow = newRows[newItemPosition]
            return oldRow == newRow
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldRow = oldRows[oldItemPosition]
            val newRow = newRows[newItemPosition]
            return oldRow == newRow
        }

        override fun getOldListSize(): Int = oldRows.size

        override fun getNewListSize(): Int = newRows.size

    })

    diff.dispatchUpdatesTo(this)
    this.notifyDataSetChanged()
}

/**
 * Фильтрует альбомы по алфавиту
 */
fun List<Currency>.filterByCollectionName(): List<Currency> {
    return this.sortedWith(compareBy { it.name })
}