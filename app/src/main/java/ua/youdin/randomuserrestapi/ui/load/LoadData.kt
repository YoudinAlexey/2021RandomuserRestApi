package ua.youdin.randomuserrestapi.ui.load

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlinx.coroutines.flow.collect
import ua.youdin.randomuserrestapi.R
import ua.youdin.randomuserrestapi.databinding.FragmentLoadDataBinding

@InternalCoroutinesApi
class LoadData : Fragment(R.layout.fragment_load_data) {

    private var _binding: FragmentLoadDataBinding? = null
    private val binding get() = _binding!!
    private val viewmodel by sharedViewModel<LoadDataViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoadDataBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val adapter = LoadAdapter(viewmodel)
        binding.list.adapter = adapter
        lifecycleScope.launch {
            viewmodel.loadData().collectLatest {
                adapter.submitData(it)
            }
        }
        lifecycleScope.launch {
            adapter.loadStateFlow
                .distinctUntilChangedBy { it.refresh }
                .filter { it.refresh is LoadState.NotLoading }
                .collect { binding.list.scrollToPosition(viewmodel.currentPosition) }
        }
        return binding.root
    }
}