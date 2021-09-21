package com.fr1x3.foodjournal.ui.views

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.fr1x3.foodjournal.R
import com.fr1x3.foodjournal.databinding.FragmentHomeBinding
import com.fr1x3.foodjournal.utils.Constants
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    private var  _bindingHome: FragmentHomeBinding? = null
    val bindingHome  get() = _bindingHome!!
    private var isRequestGranted :Boolean = false
    private val  TAG = "HomeFragment"

    private val navController by lazy{
        findNavController()
    }

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

        bindingHome.fabGallery.setOnClickListener(){
            /* check for permission then
                navigate to photo gallery
             */
            if( hasPermissions() || isRequestPermissionGranted())
                navigateToGallery()
        }

        bindingHome.fabPhoto.setOnClickListener(){
            // check for permission
            // then navigate to photo fragment
            if( hasPermissions() || isRequestPermissionGranted()){
                // todo: set up camera
                navigateToPhoto()
            }
        }
    }

    fun navigateToGallery(){
        navController.navigate(R.id.action_nav_home_to_nav_gallery)
    }

    fun navigateToPhoto(){
        navController.navigate(R.id.action_nav_home_to_nav_photo)
    }

    fun hasPermissions() : Boolean =
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    //flag if the  permission request has been successfull
    fun isRequestPermissionGranted() : Boolean{
        requestPermission()
        return isRequestGranted
    }
    val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()
            ){ isGranted : Boolean ->
                if( isGranted){
                    isRequestGranted = true
                   Log.d(TAG, "successful permission request")
                }else{
                    Snackbar.make( requireView(),"Sorry cannot proceed without permission to access camera for  photo or storage", Snackbar.LENGTH_LONG)
                    Log.d(TAG, "failed on activity result permission request")
                }

            }

    fun requestPermission(){
        if( shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                // show message on why you need the permission todo: sort rationale
            Log.d(TAG, "show permission rationale")
            Snackbar.make( requireView(),"Sorry cannot proceed without permission to access camera for  photo or storage", Snackbar.LENGTH_LONG)
        }
        else
            requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }

}