package br.com.arllain.mysharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

const val KEY_NAME = "key_name"
const val KEY_IDADE = "key_idade"
const val MY_SHARED_PREFS = "my_shared_prefs"
const val NOME = "Nome:"
const val IDADE = "Idade:"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.tvResult).text = ""

        findViewById<Button>(R.id.btnWrite).setOnClickListener {
            writeOnSharedPreferences()
        }

        findViewById<Button>(R.id.btnRead).setOnClickListener {
            readOnSharedPreferences()
        }

    }

    private fun writeOnSharedPreferences() {
        val sp = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE)

        val edtNome = findViewById<EditText>(R.id.edtName)
        val edtIdade = findViewById<EditText>(R.id.edtIdade)

        sp.edit()
            .putString(KEY_NAME, edtNome.text.toString())
            .putInt(KEY_IDADE, edtIdade.text.toString().toInt())
            .apply()
    }

    private fun readOnSharedPreferences() {
        val sp = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE)
        val nome  = sp.getString(KEY_NAME, "")
        val idade = sp.getInt(KEY_IDADE, 0)
        val result = "$NOME $nome - $IDADE $idade"
        findViewById<TextView>(R.id.tvResult).text = result
    }
}