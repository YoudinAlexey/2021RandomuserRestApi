package ua.youdin.randomuserrestapi.ui.load

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import ua.youdin.randomuserrestapi.R
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data
import ua.youdin.randomuserrestapi.databinding.ItemLoadDataBinding

class DataViewHolder(private val binding: ItemLoadDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(itemData: Data, viewModel: LoadDataViewModel, position: Int) {
        binding.position = position
        binding.viewmodel = viewModel
        binding.data = itemData
        binding.executePendingBindings()
    }

    companion object {
        fun create(parent: ViewGroup): DataViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_load_data, parent, false)
            val binding = ItemLoadDataBinding.bind(view)
            return DataViewHolder(binding)
        }
    }

}
