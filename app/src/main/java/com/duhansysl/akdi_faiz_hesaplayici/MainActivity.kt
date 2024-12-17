package com.duhansysl.akdi_faiz_hesaplayici

import android.content.Intent
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

            val intent = Intent(this, SonucActivity::class.java)

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

            // HESAPLAMALAR

            // Toplam Gün
            val toplamGun = odemeGun + gecikmeGun

            // Asgari Tutar Hesabı
            val asgariTutar = toplamBorc * (asgariOdemeOrani / 100)

            // Geriye Kalan Borç
            var geriyeKalanBorc = (toplamBorc - odenen).coerceAtLeast(0.00)

            // Geriye Kalan Asgari Borç
            val geriyeKalanAsgariBorc = asgariTutar - odenen

            // Alışveriş Faizi ve Gecikme Faizi (Hesap Kesim ile Son Ödeme Tarihi Arası)
            var alisverisFaiziBirinci = (geriyeKalanBorc * akdiFaiz / 100) * (odemeGun / 30.0)
            var alisverisFaiziIkinci = (geriyeKalanBorc * akdiFaiz / 100) * (gecikmeGun / 30.0)

            // Gecikme Faizi Hesabı
            val gecikmeFaizTutari = if (odenen < asgariTutar) {
                (geriyeKalanAsgariBorc * gecikmeFaiz / 100) * (gecikmeGun / 30.0)
            } else {
                0.0
            }

            // Toplam Faiz
            val toplamFaiz = alisverisFaiziBirinci + alisverisFaiziIkinci + gecikmeFaizTutari

            // Vergi Tutarı
            val vergiTutari = (toplamFaiz * vergiOrani / 100)

            // Toplam Maliyet
            val toplamMaliyet = toplamFaiz + vergiTutari

            // Eğer Ödenen Miktar Toplam Borçtan Fazlaysa
            if (odenen >= toplamBorc) {
                geriyeKalanBorc = 0.0
                alisverisFaiziBirinci = 0.0
                alisverisFaiziIkinci = 0.0
            }

            // Sonuçları Yazdır
//            println("Asgari Tutar: $asgariTutar")
//            println("Geriye Kalan Borç: $geriyeKalanBorc")
//            println("Geriye Kalan Asgari Borç: $geriyeKalanAsgariBorc")
//            println("Alışveriş Faizi Birinci: $alisverisFaiziBirinci")
//            println("Gecikme Faizi: $gecikmeFaizi")
//            println("Alışveriş Faizi İkinci: $alisverisFaiziIkinci")
//            println("Toplam Faiz: $toplamFaiz")
//            println("Vergi Tutarı: $vergiTutari")
//            println("Toplam Maliyet: $toplamMaliyet")
//            println("Toplam Gün: $toplamGun")

            intent.putExtra("toplamGun", toplamGun)
            intent.putExtra("toplamBorc", borc)
            intent.putExtra("asgariOdemeMiktari", asgariTutar)
            intent.putExtra("odenenBorcMiktari", odenen)
            intent.putExtra("kalanBorcMiktari", geriyeKalanBorc)
            intent.putExtra("kalanAsgariBorcMiktari", geriyeKalanAsgariBorc)
            intent.putExtra("alisverisFaizBirinci", alisverisFaiziBirinci)
            intent.putExtra("alisverisFaizIkinci", alisverisFaiziIkinci)
            intent.putExtra("toplamFaizTutari", toplamFaiz)
            intent.putExtra("gecikmeFaizTutari", gecikmeFaizTutari)
            intent.putExtra("vergiTutari", vergiTutari)
            intent.putExtra("toplamMaliyet", toplamMaliyet)
            intent.putExtra("vergiOrani", vergiOrani)
            intent.putExtra("faizOrani", akdiFaiz)
            intent.putExtra("cezaFaizOrani", gecikmeFaiz)
            intent.putExtra("asgariOran", asgariOdemeOrani)

            // 2. Aktiviteyi başlat (SonucActivity)
            startActivity(intent)
        }
    }
}
