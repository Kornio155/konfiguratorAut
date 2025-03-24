package com.example.konfiguratoraut

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var selectedCar: String = "Nie wybrano podwozia!"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var zdj = findViewById<ImageView>(R.id.zdjecie)
        val buttonSubmit: Button = findViewById(R.id.buton)

        var grupa = findViewById<RadioGroup>(R.id.auto_Radio)
        grupa.setOnCheckedChangeListener { _, checkedId ->
            selectedCar = findViewById<RadioButton>(checkedId).text.toString()
            when(selectedCar){
                "SUV" -> zdj.setImageResource(R.drawable.suv)
                "Sedan" -> zdj.setImageResource(R.drawable.hatchback)
                "HatchBack" -> zdj.setImageResource(R.drawable.hatchback)
            }
        }
        buttonSubmit.setOnClickListener{
            var opcja = ""
            var skora = findViewById<CheckBox>(R.id.skf).isChecked
            var klima = findViewById<CheckBox>(R.id.kli).isChecked

            when{
                (skora == true && klima == true) -> opcja = "Z fotelami skórzanymi i klimą"
                (skora == true && klima == true) -> opcja = "Z fotelami skórzanymi bez klimy"
                (skora == true && klima == true) -> opcja = "Z fotelami zwykłymi i klimą"
                else -> opcja = "Z fotelami zwykłymi i bez klimy"
            }
            when(selectedCar){
                "SUV" -> findViewById<TextView>(R.id.podsumowanie).text = "Wybrane podwozie to SUV ${opcja}"
                "Sedan" -> findViewById<TextView>(R.id.podsumowanie).text = "Wybrane podwozie to Sedan ${opcja}"
                "HatchBack" -> findViewById<TextView>(R.id.podsumowanie).text = "Wybrane podwozie to HatchBack ${opcja}"

            }
        }
    }
}