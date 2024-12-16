package com.duhansysl.akdi_faiz_hesaplayici

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.duhansysl.akdi_faiz_hesaplayici.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Veriyi diğer aktiviteden inten sayesinde alma
        val toplamGun = intent.getIntExtra("toplamGun", 0)
        val toplamBorc = intent.getDoubleExtra("toplamBorc", 0.0)
        val asgariOdemeMiktari = intent.getDoubleExtra("asgariOdemeMiktari", 0.0)
        val odenenBorcMiktari = intent.getDoubleExtra("odenenBorcMiktari", 0.0)
        val kalanBorcMiktari = intent.getDoubleExtra("kalanBorcMiktari", 0.0)
        var kalanAsgariBorcMiktari = intent.getDoubleExtra("kalanAsgariBorcMiktari", 0.0)
        val alisverisFaizBirinci = intent.getDoubleExtra("alisverisFaizBirinci", 0.0)
        val alisverisFaizIkinci = intent.getDoubleExtra("alisverisFaizIkinci", 0.0)
        val toplamFaizTutari = intent.getDoubleExtra("toplamFaizTutari", 0.0)
        val vergiTutari = intent.getDoubleExtra("vergiTutari", 0.0)
        val toplamMaliyet = intent.getDoubleExtra("toplamMaliyet", 0.0)
        val vergiOrani = intent.getDoubleExtra("vergiOrani", 0.0)
        val faizOrani = intent.getDoubleExtra("faizOrani", 0.0)
        val cezaFaizOrani = intent.getDoubleExtra("cezaFaizOrani", 0.0)
        val gecikmeFaizTutari = intent.getDoubleExtra("gecikmeFaizTutari", 0.0)
        val asgariOran = intent.getDoubleExtra("asgariOran", 0.0)

        if(kalanAsgariBorcMiktari < 0.0) {
            kalanAsgariBorcMiktari = 0.0
        }

        // Gelen verileri ViewBinding ile gösterme
        // binding.textView.text = "Received Float: $receivedFloat\nReceived String: $receivedString"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}