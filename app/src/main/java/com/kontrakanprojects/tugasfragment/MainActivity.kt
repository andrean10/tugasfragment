package com.kontrakanprojects.tugasfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kontrakanprojects.tugasfragment.adapter.SectionsPagerAdapter
import com.kontrakanprojects.tugasfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewPager.adapter = SectionsPagerAdapter(this@MainActivity, supportFragmentManager)
            tabs.setupWithViewPager(viewPager)
        }
    }
}