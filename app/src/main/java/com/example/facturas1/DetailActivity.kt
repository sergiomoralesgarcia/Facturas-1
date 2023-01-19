package com.example.facturas1

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import androidx.core.graphics.ColorUtils
import androidx.fragment.app.DialogFragment
import androidx.sqlite.db.SupportSQLiteCompat.Api16Impl.cancel
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

        val button: Button = view.findViewById(R.id.botonPopup)

        button.setOnClickListener{
            dismiss()
        }
    }

    /*val alertDialog: AlertDialog? = activity?.let {
        val builder = AlertDialog.Builder(it)
        builder.apply {
            setNegativeButton(R.string.etq_textoPopup,
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        }

        // Create the AlertDialog
        builder.create()
    }*/
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


    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding = ActivityDetailBinding.inflate(layoutInflater)

        // Cierre de la ventana emergente cuando presione el botón
        binding.botonPopup.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }*/
}