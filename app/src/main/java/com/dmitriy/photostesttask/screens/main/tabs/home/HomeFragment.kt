package com.dmitriy.photostesttask.screens.main.tabs.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.dmitriy.photostesttask.CoreApplication
import com.dmitriy.photostesttask.R
import com.dmitriy.photostesttask.adapter.PhotoAdapter
import com.dmitriy.photostesttask.databinding.FragmentHomeBinding
import com.dmitriy.photostesttask.di.HomeViewModelFactory
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    lateinit var viewModel: HomeViewModel

    private val photoAdapter = PhotoAdapter {
        onGoToDetails(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (requireActivity().applicationContext as CoreApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
        viewModel.fetchPhotos()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeGetPhotosEvent()
    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = photoAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun observeGetPhotosEvent() = viewModel.data.observe(viewLifecycleOwner) {
        Log.d("logs", it.toString())
        photoAdapter.diffAsync.submitList(it)
    }

    private fun onGoToDetails(imageUrl: String) {
        val directions = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(imageUrl)
        findNavController().navigate(directions)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}