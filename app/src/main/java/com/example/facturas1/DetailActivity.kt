package com.example.facturas1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.facturas1.databinding.ActivityDetailBinding

class DetailActivity: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.activity_detail, container, false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // botón cerrar
        val button: Button = view.findViewById(R.id.botonPopup)
        button.setOnClickListener{
            dismiss()
        }
    }
}

class Constants {
    companion object {
        const val FACTURE_TITLE_KEY = "FACTURE_TITLE_KEY"
        const val FACTURE_DATE_KEY = "FACTURE_DATE_KEY"
        const val FACTURE_CONTENT_KEY = "FACTURE_CONTENT_KEY"
    }
}

class PopupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    var title: String? = null
    var content: String? = null
    var close: String? = null

    companion object {
        @JvmStatic
        fun start(context: Context, title: String, content: String, close: String) {
            val starter = Intent(context, DetailActivity::class.java)
                .putExtra(Constants.FACTURE_TITLE_KEY, title)
                .putExtra(Constants.FACTURE_DATE_KEY, content)
                .putExtra(Constants.FACTURE_CONTENT_KEY, close)
            context.startActivity(starter)
        }
    }
}