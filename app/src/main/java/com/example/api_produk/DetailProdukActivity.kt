package com.example.api_produk

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailProdukActivity : AppCompatActivity() {
    private lateinit var imgDetailProduk : ImageView
    private lateinit var txtDetailTitle : TextView
    private lateinit var txtDetailDeskripsi : TextView
    private lateinit var txtDetailPrice  : TextView
    private lateinit var txtDetailStok : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_produk)

        imgDetailProduk = findViewById(R.id.imgDetailProduk)
        txtDetailTitle = findViewById(R.id.txtDetailTitle)
        txtDetailDeskripsi = findViewById(R.id.txtDetailBrand)
        txtDetailPrice = findViewById(R.id.txtDetailPrice)
        txtDetailStok = findViewById(R.id.txtDetailStok)

        val img = intent.getStringExtra("thumbnail")
        val title = intent.getStringExtra("title")
        val deskripsi = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price",0.0)
        val stok = intent.getIntExtra("stock",0)


        Glide.with(this).load(img).centerCrop().into(imgDetailProduk)
        txtDetailDeskripsi.text = deskripsi
        txtDetailTitle.text = title
        txtDetailPrice.text = price.toString()
        txtDetailStok.text = stok.toString()



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}