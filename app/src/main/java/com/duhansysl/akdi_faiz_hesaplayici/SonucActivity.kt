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
        val toplamGun = intent.getFloatExtra("toplamGun", 0.0f)
        val toplamBorc = intent.getFloatExtra("toplamBorc", 0.0f)
        val asgariOdemeMiktari = intent.getFloatExtra("asgariOdemeMiktari", 0.0f)
        val odenenBocMiktari = intent.getFloatExtra("odenenBocMiktari", 0.0f)
        val kalanBorcMiktari = intent.getFloatExtra("kalanBorcMiktari", 0.0f)
        val kalanAsgariBorcMiktari = intent.getFloatExtra("kalanAsgariBorcMiktari", 0.0f)
        val alisverisFaizBirinci = intent.getFloatExtra("alisverisFaizBirinci", 0.0f)
        val alisverisFaizIkinci = intent.getFloatExtra("alisverisFaizIkinci", 0.0f)
        val toplamFaizTutari = intent.getFloatExtra("toplamFaizTutari", 0.0f)
        val vergiTutari = intent.getFloatExtra("vergiTutari", 0.0f)
        val toplamMaliyet = intent.getFloatExtra("toplamMaliyet", 0.0f)

        // Gelen verileri ViewBinding ile gösterme
        // binding.textView.text = "Received Float: $receivedFloat\nReceived String: $receivedString"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}