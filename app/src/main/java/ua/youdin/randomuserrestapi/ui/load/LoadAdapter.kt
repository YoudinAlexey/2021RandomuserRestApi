package ua.youdin.randomuserrestapi.ui.load

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data

class LoadAdapter(
    private val viewModel: LoadDataViewModel,
) : PagingDataAdapter<Data, DataViewHolder>(DATA_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder.create(parent)

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            holder.bind(repoItem, viewModel, position)
        }
    }

    companion object {
        private val DATA_COMPARATOR = object : DiffUtil.ItemCallback<Data>() {
            override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean =
                oldItem.phone == newItem.phone

            override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean =
                oldItem == newItem
        }
    }


}
