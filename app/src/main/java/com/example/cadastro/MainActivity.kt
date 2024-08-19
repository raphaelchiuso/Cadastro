package com.example.cadastro

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.Cadastro.Formulario
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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
        binding.spinnerEstado.adapter = adapter

        binding.buttonSalvar.setOnClickListener {
            val nome = binding.editTextNome.text.toString()
            val telefone = binding.editTextTelefone.text.toString()
            val email = binding.editTextEmail.text.toString()
            val ingressarNaLista = binding.checkBoxEmailList.isChecked
            val sexo = when (binding.radioGroupSexo.checkedRadioButtonId) {
                R.id.radioButtonMasculino -> "Masculino"
                R.id.radioButtonFeminino -> "Feminino"
                else -> "Não especificado"
            }
            val cidade = binding.editTextCidade.text.toString()
            val estado = binding.spinnerEstado.selectedItem.toString()

            val formulario =
                Formulario(nome, telefone, email, ingressarNaLista, sexo, cidade, estado)

            Toast.makeText(this, formulario.toString(), Toast.LENGTH_LONG).show()
        }

        binding.buttonLimpar.setOnClickListener {
            binding.editTextNome.text.clear()
            binding.editTextTelefone.text.clear()
            binding.editTextEmail.text.clear()
            binding.checkBoxEmailList.isChecked = false
            binding.radioGroupSexo.clearCheck()
            binding.editTextCidade.text.clear()
            binding.spinnerEstado.setSelection(0)
        }
    }
}
