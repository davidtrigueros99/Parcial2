package com.example.parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {
    private  var gvTabla: GridView? = null

    var especie = arrayListOf<String>("Perro", "Gato", "Conejo", "Tortuga")
    var sexo = arrayListOf<String>("Macho", "Macho", "Hembra", "Hembra")
    var habitat = arrayListOf<String>("Terrestre", "Terrestre", "Terrestre", "Maritimo")
    var imagenes = arrayOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4
    )
    var imagenesLista = arrayOf(
        ImgItems(imagenes.get(0), especie.get(0), sexo.get(0), habitat.get(0)),
        ImgItems(imagenes.get(1), especie.get(1), sexo.get(1), habitat.get(0)),
        ImgItems(imagenes.get(2), especie.get(2), sexo.get(2), habitat.get(0)),
        ImgItems(imagenes.get(3), especie.get(3), sexo.get(3), habitat.get(0))
    )

    var myImagenLista = ArrayList<ImgItems>()
    var modificadorAdaptador:AdaptadorModificado? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        for (imagen in imagenesLista){
            myImagenLista.add(imagen)
        }

        gvTabla = findViewById(R.id.gv_Tabla)

        modificadorAdaptador = AdaptadorModificado(myImagenLista, this)
        gvTabla?.adapter = modificadorAdaptador

        gvTabla?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var ventana: Intent = Intent(applicationContext, Detalle::class.java)
                ventana.putExtra("imagen", imagenes.get(position))
                ventana.putExtra("especie", especie.get(position))
                ventana.putExtra("sexo", sexo.get(position))
                ventana.putExtra("habitat", habitat.get(position))
                startActivity(ventana)
            }

        }
    }
}