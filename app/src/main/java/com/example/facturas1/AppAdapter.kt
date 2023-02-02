package com.example.facturas1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas1.databinding.ItemFacturaBinding
import com.example.facturas1.entidades.Factura

class AppAdapter (var datos: MutableList<Factura>): RecyclerView.Adapter<AppAdapter.AppHolder>(){

    var onItemClick : ((Factura) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        val inflador = LayoutInflater.from(parent.context)
        val binding = ItemFacturaBinding.inflate(inflador,parent,false)

        return AppHolder(binding)
    }

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bindItem(datos[position])

        // presionar en el contenedor del adapter
        val factura = datos[position]
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(factura)
        }
    }

    override fun getItemCount(): Int = datos.size

    inner class AppHolder(val binding: ItemFacturaBinding ): RecyclerView.ViewHolder(binding.root){
        var container: ConstraintLayout? = null

        init {
            container = itemView.findViewById(R.id.itemContainer)
        }

        fun bindItem(factura: Factura){
            with(binding){
                fecha.text = factura.fecha
                descEstado.text = factura.descEstado
                importeOrdenacion. text = factura.importeOrdenacion.toString()
            }
        }
    }

    fun updateFacturas(datos: MutableList<Factura>){
        this.datos = datos
        notifyDataSetChanged()
    }
}
