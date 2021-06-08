package com.kontrakanprojects.tugasfragment.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kontrakanprojects.tugasfragment.databinding.FragmentFirstBinding
import com.kontrakanprojects.tugasfragment.viewmodel.PageViewModel

class FirstFragment : Fragment() {

    private var viewModel: PageViewModel? = null
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val TAG = FirstFragment::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity())[PageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.teName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel!!.setName(p0.toString())

                Log.d(TAG, "onTextChanged: $p0")
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    companion object {
        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}