package com.example.facturas1.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.facturas1.entidades.Factura

@Database(entities = arrayOf(Factura::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun dao(): AppDao

    companion object{
        @Volatile
        var db: AppDatabase? = null

        @Synchronized
        fun database(contexto: Context): AppDao?{
            if (db == null)
                db = Room.databaseBuilder(contexto, AppDatabase::class.java, "facturas")
                    .allowMainThreadQueries()
                    .build()
            return db?.dao()
        }
    }
}