package com.example.facturas1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas1.databinding.ItemFacturaBinding
import com.example.facturas1.entidades.Factura

class AppAdapter (var datos: MutableList<Factura>): RecyclerView.Adapter<AppAdapter.AppHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        val inflador = LayoutInflater.from(parent.context)
        val binding = ItemFacturaBinding.inflate(inflador,parent,false)

        return AppHolder(binding)
    }

    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bindItem(datos[position])
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

                // Contenedores del recycler presionables
                container?.setOnClickListener {
                    /*val dialog = DetailActivity()

                    dialog.show(supportFragmentManager, "customDialog")*/
                }
            }
        }
        /*init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }*/
    }

    fun updateFacturas(datos: MutableList<Factura>){
        this.datos = datos
        notifyDataSetChanged()
    }
}
