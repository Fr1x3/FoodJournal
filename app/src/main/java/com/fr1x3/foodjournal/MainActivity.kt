package com.fr1x3.foodjournal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fr1x3.foodjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main )
    }


}