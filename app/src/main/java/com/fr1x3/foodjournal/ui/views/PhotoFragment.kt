package com.fr1x3.foodjournal.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.fr1x3.foodjournal.R
import com.fr1x3.foodjournal.databinding.FragmentPhotoBinding

class PhotoFragment : Fragment() {

    private var  _binding : FragmentPhotoBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)
        return  binding.root
    }

}