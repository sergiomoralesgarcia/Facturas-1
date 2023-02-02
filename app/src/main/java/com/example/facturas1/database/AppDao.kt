package com.example.facturas1.database

import androidx.room.Dao
import androidx.room.Query
import com.example.facturas1.entidades.Factura

@Dao
interface AppDao {

    @Query("SELECT * FROM factura")
    fun getAll(): MutableList<Factura>

}