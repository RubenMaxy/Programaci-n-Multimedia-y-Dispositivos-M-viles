package com.example.listacompravm.model

import com.example.listacompravm.data.ProductInitial

data class ProductInitial (val name:String, var checked: Boolean= false){}

fun getListaCompra() = ProductInitial.map {
        ProductInitial(it)
}