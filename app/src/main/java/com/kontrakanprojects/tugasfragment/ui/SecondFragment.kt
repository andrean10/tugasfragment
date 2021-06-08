package com.kontrakanprojects.tugasfragment.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kontrakanprojects.tugasfragment.databinding.FragmentSecondBinding
import com.kontrakanprojects.tugasfragment.viewmodel.PageViewModel

class SecondFragment : Fragment() {

    private var viewModel: PageViewModel? = null
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val TAG = SecondFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[PageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel!!.name.observe(viewLifecycleOwner, { value ->
            binding.tvName.text = value

            Log.d(TAG, "onViewCreated: $value")
        })
    }

    companion object {
        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}