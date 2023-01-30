package com.example.facturas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas1.database.AppDatabase
import com.example.facturas1.databinding.ActivityMainBinding
import com.example.facturas1.entidades.Factura

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptador: AppAdapter
    private lateinit var recyclerqView: RecyclerView

    private var datos: MutableList<Factura> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        datos = AppDatabase.database(this@MainActivity)?.getAll()!!
        datos.add(Factura(0,"Pendiente de pago", 1.5600000000000001, "07/02/2019"))
        datos.add(Factura(1,"Pagada", 25.140000000000001, "05/02/2019"))
        datos.add(Factura(2,"Pagada", 22.690000000000001, "08/01/2019"))
        datos.add(Factura(3,"Pendiente de pago", 12.84, "07/12/2018"))
        datos.add(Factura(4,"Pagada", 35.159999999999997, "16/11/2018"))
        datos.add(Factura(5,"Pagada", 18.27, "05/10/2018"))
        datos.add(Factura(6,"Pendiente de pago", 61.170000000000002, "05/09/2018"))
        datos.add(Factura(7,"Pagada", 37.18, "07/08/2018"))

        adaptador = AppAdapter(datos)

        with(binding){
            FacturaList.adapter = adaptador
            FacturaList.setHasFixedSize(true)
        }

        // abrir página filtros
        binding.botonFactura.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }

        // abrir popup presionando en el contenedor del recycler
        adaptador.onItemClick = {
            val dialog = DetailActivity()

            dialog.show(supportFragmentManager, "customDialog")
        }
    }

    private fun navigateTo(factura: Any) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}