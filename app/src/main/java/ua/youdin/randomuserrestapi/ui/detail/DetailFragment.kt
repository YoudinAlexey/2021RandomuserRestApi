package ua.youdin.randomuserrestapi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.coroutines.InternalCoroutinesApi
import ua.youdin.randomuserrestapi.R
import ua.youdin.randomuserrestapi.databinding.FragmentDetailBinding


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.data = DetailFragmentArgs.fromBundle(requireArguments()).data
        return binding.root
    }

}