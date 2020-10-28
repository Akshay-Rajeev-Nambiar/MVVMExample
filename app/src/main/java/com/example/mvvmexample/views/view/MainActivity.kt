package com.example.mvvmexample.views.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmexample.R
import com.example.mvvmexample.views.viewmodel.MainActivityViewModel
import java.lang.StringBuilder

/*
    View component-
    The view class is supposed to contain
    all the Ui components which is used for handling all
    the UI and the interactions.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var liveDataBtn: Button
    private lateinit var normalBtn: Button
    private lateinit var dummyText: TextView
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        liveDataBtn = findViewById(R.id.color_live_data_btn)
        normalBtn = findViewById(R.id.color_btn)
        dummyText = findViewById(R.id.main_tv)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        var number = 0
        liveDataBtn.setOnClickListener {
            viewModel.changeValue()
        }
        viewModel.random.observe(this,{
            dummyText.text = StringBuilder("Value $it")
        })
        normalBtn.setOnClickListener{
            dummyText.text = "Value ${number++}"
        }
    }
}