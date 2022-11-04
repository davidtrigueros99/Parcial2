package com.example.parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class Detalle : AppCompatActivity() {
    lateinit var tvEspecie: TextView
    lateinit var tvSexo: TextView
    lateinit var ivImgFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        tvEspecie = findViewById(R.id.tv_Especie2)
        tvSexo = findViewById(R.id.tv_Sexo2)
        ivImgFoto = findViewById(R.id.iv_ImgFoto)

        var bundle:Bundle = getIntent().getExtras()!!

        tvEspecie.setText(bundle.getString("especie"))
        tvSexo.setText(bundle.getString("sexo"))
        ivImgFoto.setImageResource(bundle.getInt("imagen"))
    }
}