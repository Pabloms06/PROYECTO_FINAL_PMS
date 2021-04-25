package com.cbellmont.ejercicioadapterstarwars

import MusicAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbellmont.ejercicioadapterstarwars.databinding.ActivityMainBinding
import com.example.proyecto_final_pms.SecondActivityViewModel
import com.example.proyecto_final_pms.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private var adapter : MusicAdapter = MusicAdapter()
    private lateinit var model : SecondActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model = ViewModelProvider(this).get(SecondActivityViewModel::class.java)
        createRecyclerView()
        downloadAll()
    }

    private fun createRecyclerView() {
        binding.
        binding.filmRecyclerView.adapter = adapter
    }


    private fun downloadAll(){
        lifecycleScope.launch {
            binding.pbLoading.visibility = View.VISIBLE
            val list = model.getFilms()
            Log.w("Pablo", list.toString())
            adapter.updateFilms(list)
            binding.pbLoading.visibility = View.GONE
        }
    }


}