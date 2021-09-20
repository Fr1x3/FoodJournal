package com.fr1x3.foodjournal.ui.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fr1x3.foodjournal.R
import com.fr1x3.foodjournal.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var  _bindingHome: FragmentHomeBinding? = null
    val bindingHome  get() = _bindingHome!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         _bindingHome =   DataBindingUtil.inflate(inflater, R.layout.fragment_home,  container,false)
        return bindingHome.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        bindingHome.fabGallery.setOnClickListener(){
            navController.navigate(R.id.action_nav_home_to_nav_gallery)
        }
        bindingHome.fabPhoto.setOnClickListener(){
            navController.navigate(R.id.action_nav_home_to_nav_photo)
        }
    }


}