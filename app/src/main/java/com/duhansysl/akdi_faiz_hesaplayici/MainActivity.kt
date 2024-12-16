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

            val limit = binding.limitPlainText.text.toString().toDoubleOrNull() ?: 0.0
            val borc = binding.borcPlainText.text.toString().toDoubleOrNull() ?: 0.0
            val odenen = binding.odenenPlainText.text.toString().toDoubleOrNull() ?: 0.0
            val odemeGun = binding.hesapKesimSonOdemeGun.text.toString().toIntOrNull() ?: 0
            val gecikmeGun = binding.gecikenGunPlain.text.toString().toIntOrNull() ?: 0

            var akdiFaiz: Double = 0.00
            var gecikmeFaiz: Double = 0.00
            var asgariOdemeOrani: Double = 0.00
            var toplamBorc: Double = borc

            if (limit <= 25000) {
                akdiFaiz = akdiFaizOraniKucuk
                gecikmeFaiz = gecikmeFaizOraniKucuk
                asgariOdemeOrani = asgariOdemeOraniKucuk
            } else if (limit <= 150000) {
                akdiFaiz = akdiFaizOraniOrta
                gecikmeFaiz = gecikmeFaizOraniOrta
                asgariOdemeOrani = asgariOdemeOraniBuyuk
            } else {
                akdiFaiz = akdiFaizOraniBuyuk
                gecikmeFaiz = gecikmeFaizOraniBuyuk
                asgariOdemeOrani = asgariOdemeOraniBuyuk
            }
        }
    }
}