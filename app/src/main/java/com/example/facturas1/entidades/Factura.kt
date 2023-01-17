package com.example.facturas1.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Factura(@PrimaryKey (autoGenerate = true) var idFac: Int,
                    var descEstado: String,
                    var importeOrdenacion: Double,
                    var fecha: String)
