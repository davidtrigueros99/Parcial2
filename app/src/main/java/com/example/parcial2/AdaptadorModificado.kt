package com.example.parcial2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorModificado(var imagenLista:ArrayList<ImgItems>, var context: Context):BaseAdapter() {
    override fun getCount(): Int {
        return imagenLista.size
    }

    override fun getItem(position: Int): Any {
        return imagenLista[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if(vista == null){
            vista = LayoutInflater.from(context).inflate(R.layout.fila_items, parent, false)
        }
        var imagenVista:ImageView =  vista!!.findViewById(R.id.iv_Tabla)
        var tvespecie:TextView =  vista!!.findViewById(R.id.tv_Especie)
        var tvsexo:TextView =  vista!!.findViewById(R.id.tv_Sexo)
        var tvhabitat:TextView =  vista!!.findViewById(R.id.tv_Habitat)

        val imgItems = imagenLista[position]
        imagenVista.setImageResource(imgItems.imagen)
        tvespecie.text = imgItems.especie
        tvsexo.text = imgItems.sexo
        tvhabitat.text = imgItems.habitat

        return vista
    }

}