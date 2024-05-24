package com.example.quotesapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.quotesapi.databinding.ActivityMainBinding
import com.example.quotesapi.ui.viewmodels.QuotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: QuotesViewModel

    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.quotesFlow.collect{quotesResponse ->
                withContext(Dispatchers.Main) {
                    if (quotesResponse == null) {
                        binding.tvText.text = "Waiting"
                    } else  binding.tvText.text = quotesResponse[0].text
            }}
        }

    }
}