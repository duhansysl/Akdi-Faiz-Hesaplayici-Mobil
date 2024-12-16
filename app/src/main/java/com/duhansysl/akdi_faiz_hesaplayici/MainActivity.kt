package com.duhansysl.akdi_faiz_hesaplayici

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duhansysl.akdi_faiz_hesaplayici.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val akdiFaizOraniKucuk: Double = 3.50
    private val gecikmeFaizOraniKucuk: Double = 3.80
    private val akdiFaizOraniOrta: Double = 4.25
    private val gecikmeFaizOraniOrta: Double = 4.55
    private val akdiFaizOraniBuyuk: Double = 4.75
    private val gecikmeFaizOraniBuyuk: Double = 5.05
    private val asgariOdemeOraniKucuk: Double = 20.0
    private val asgariOdemeOraniBuyuk: Double = 40.0
    private val vergiOrani: Double = 30.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalculate.setOnClickListener() {
        }
    }
}