package com.example.facturas1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.facturas1.databinding.ItemFacturaBinding
import com.example.facturas1.entidades.Factura

class AppAdapter (val datos: MutableList<Factura>): RecyclerView.Adapter<AppAdapter.AppHolder>(){

    private lateinit var mListener: OnItemClickListener

    interface onIntemClickListener{
        fun onItemClick (position: Int)
    }

    fun setOnItemClickListener (listener: OnItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppHolder {
        val inflador = LayoutInflater.from(parent.context)
        val binding = ItemFacturaBinding.inflate(inflador,parent,false)

        return AppHolder(binding)
    }
    // mListener
    override fun onBindViewHolder(holder: AppHolder, position: Int) {
        holder.bindItem(datos[position])
    }

    override fun getItemCount(): Int = datos.size
    //listener: OnItemClickListener
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
                container?.setOnClickListener {
                    //startActivity(Intent(this,DetailActivity::class.java))
                }
            }

        }
        /*init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }*/
    }
}
