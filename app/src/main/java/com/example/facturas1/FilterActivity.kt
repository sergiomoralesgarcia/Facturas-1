package com.example.facturas1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android.widget.Adapter
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.example.facturas1.databinding.ActivityFilterBinding
import com.example.facturas1.entidades.Factura
import java.util.*

class FilterActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding: ActivityFilterBinding
    private lateinit var adapter: AppAdapter

    private var datos: MutableList<Factura> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilterBinding.inflate(layoutInflater)

        setContentView(binding.root)


        // Botón de cancelar los filtros
        binding.cancelButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Calendario
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        binding.buttonDate1.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate1.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis

        }

        binding.buttonDate2.setOnClickListener() {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    binding.buttonDate2.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
            // fecha máxima que puedes seleccionar
            dpd.datePicker.maxDate = c.timeInMillis

        }

        // Cambio progresivo de la cantidad del SeekBar
        var progressView: TextView? = null
        var seekBar: SeekBar? = null

        progressView = this.binding.cantidad2
        seekBar = this.binding.seekBar
        seekBar!!.setOnSeekBarChangeListener(this)

        // Botón de aplicar los filtros
        binding.botonAplicar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Botón de eliminar los filtros
        binding.botonEliminar.setOnClickListener {
            startActivity(Intent(this, FilterActivity::class.java))
        }


    }

    // importaciones del SeekBar
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        binding.cantidad2!!.text = progress.toString()
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {}

    override fun onStopTrackingTouch(p0: SeekBar?) {}
}