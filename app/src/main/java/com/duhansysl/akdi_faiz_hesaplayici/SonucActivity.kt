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

        // Verileri StringBuilder'a ekleyin
        val messageText = StringBuilder()
        val valueText = StringBuilder()

        // Gelen verileri ViewBinding ile gösterme
        messageText.append("-> Toplam Geciken Gün Sayısı\n")
        messageText.append("-> Toplam Borç Miktarı\n")
        messageText.append("-> Asgari Ödeme Tutarı (%$asgariOran)\n")
        messageText.append("-> Ödenen Borç Miktarı\n")
        messageText.append("-> Kalan Borç Miktarı\n")
        messageText.append("-> Kalan Asgari Borç Miktarı\n")
        messageText.append(String.format("-> Alışveriş Faizi (1. Dönem) (%%%.2f)\n", faizOrani))
        messageText.append(String.format("-> Alışveriş Faizi (2. Dönem) (%%%.2f)\n", faizOrani))
        messageText.append(String.format("-> Ceza Faizi (%%%.2f)\n", cezaFaizOrani))
        messageText.append("-> Toplam Faiz Tutarı\n")
        messageText.append(String.format("-> Vergi Tutarı (%%%.2f)\n", vergiOrani))
        messageText.append("-> Toplam Maliyet\n")

        valueText.append(String.format(":  %d\n", toplamGun))
        valueText.append(String.format(":  %.2f ₺\n", toplamBorc))
        valueText.append(String.format(":  %.2f ₺\n", asgariOdemeMiktari))
        valueText.append(String.format(":  %.2f ₺\n", odenenBorcMiktari))
        valueText.append(String.format(":  %.2f ₺\n", kalanBorcMiktari))
        valueText.append(String.format(":  %.2f ₺\n", kalanAsgariBorcMiktari))
        valueText.append(String.format(":  %.2f ₺\n", alisverisFaizBirinci))
        valueText.append(String.format(":  %.2f ₺\n", alisverisFaizIkinci))
        valueText.append(String.format(":  %.2f ₺\n", gecikmeFaizTutari))
        valueText.append(String.format(":  %.2f ₺\n", toplamFaizTutari))
        valueText.append(String.format(":  %.2f ₺\n", vergiTutari))
        valueText.append(String.format(":  %.2f ₺\n", toplamMaliyet))


        // Sonuçları TextView'de gösterin
        binding.messageText.text = messageText.toString()
        binding.valueText.text = valueText.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}