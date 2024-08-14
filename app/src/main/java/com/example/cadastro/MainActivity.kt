package com.example.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Cadastro.Formulario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextNome: EditText = findViewById(R.id.editTextNome)
        val editTextTelefone: EditText = findViewById(R.id.editTextTelefone)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val checkBoxEmailList: CheckBox = findViewById(R.id.checkBoxEmailList)
        val radioGroupSexo: RadioGroup = findViewById(R.id.radioGroupSexo)
        val editTextCidade: EditText = findViewById(R.id.editTextCidade)
        val spinnerEstado: Spinner = findViewById(R.id.spinnerEstado)
        val buttonLimpar: Button = findViewById(R.id.buttonLimpar)
        val buttonSalvar: Button = findViewById(R.id.buttonSalvar)

        val estados = arrayOf(
            "Selecione",
            "Acre",
            "Alagoas",
            "Amazonas",
            "Bahia",
            "Ceará",
            "Distrito Federal",
            "Espírito Santo",
            "Goiás",
            "Maranhão",
            "Mato Grosso",
            "Mato Grosso do Sul",
            "Minas Gerais",
            "Pará",
            "Paraíba",
            "Paraná",
            "Pernambuco",
            "Piauí",
            "Rio de Janeiro",
            "Rio Grande do Norte",
            "Rio Grande do Sul",
            "Rondônia",
            "Roraima",
            "Santa Catarina",
            "São Paulo",
            "Sergipe",
            "Tocantins"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
        spinnerEstado.adapter = adapter

        buttonSalvar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val telefone = editTextTelefone.text.toString()
            val email = editTextEmail.text.toString()
            val ingressarNaLista = checkBoxEmailList.isChecked
            val sexo = when (radioGroupSexo.checkedRadioButtonId) {
                R.id.radioButtonMasculino -> "Masculino"
                R.id.radioButtonFeminino -> "Feminino"
                else -> "Não especificado"
            }
            val cidade = editTextCidade.text.toString()
            val estado = spinnerEstado.selectedItem.toString()

            val formulario =
                Formulario(nome, telefone, email, ingressarNaLista, sexo, cidade, estado)

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        buttonLimpar.setOnClickListener {
            editTextNome.text.clear()
            editTextTelefone.text.clear()
            editTextEmail.text.clear()
            checkBoxEmailList.isChecked = false
            radioGroupSexo.clearCheck()
            editTextCidade.text.clear()
            spinnerEstado.setSelection(0)
        }
    }
}