package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class resetpass : AppCompatActivity() {
    private lateinit var editTextPassword: EditText
    private lateinit var editTextConfirmPassword: EditText
    private lateinit var buttonSubmit: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resetpass)
        editTextPassword = findViewById(R.id.editTextTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextTextPassword1)
        buttonSubmit = findViewById(R.id.button2)

        // Ajouter un TextWatcher pour le champ de mot de passe
        editTextPassword.addTextChangedListener(passwordTextWatcher)

        // Ajouter un TextWatcher pour le champ de confirmation du mot de passe
        editTextConfirmPassword.addTextChangedListener(confirmPasswordTextWatcher)

        buttonSubmit.setOnClickListener {
            val isPasswordValid = isPasswordValid()
            if (isPasswordValid) {
                navigateToLoginActivity()
            } else {
                showSnackbar("You have some errors in your inputs!")
            }
        }
    }

    // TextWatcher pour le champ de mot de passe
    private val passwordTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            // Mettre à jour l'état du bouton "Submit" en fonction des champs de mot de passe
            showMessage(isPasswordValid())
        }
    }

    // TextWatcher pour le champ de confirmation du mot de passe
    private val confirmPasswordTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        override fun afterTextChanged(s: Editable?) {
            // Mettre à jour l'état du bouton "Submit" en fonction des champs de mot de passe
            showMessage(isPasswordValid())
        }
    }

    // Mettre à jour l'état du bouton "Submit" en fonction des champs de mot de passe
    private fun updateSubmitButtonState() {
        val isPasswordValid = isPasswordValid()
        buttonSubmit.isEnabled = isPasswordValid
    }

    // Vérifier si le mot de passe et sa confirmation sont valides
    private fun isPasswordValid(): Boolean {
        val password = editTextPassword.text.toString()
        val confirmPassword = editTextConfirmPassword.text.toString()
        return password == confirmPassword && password.length >= 8
    }

    // Naviguer vers LoginActivity
    private fun navigateToLoginActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    private fun showMessage(isPasswordValid: Boolean) {
        val message = if (isPasswordValid) {
            "Les mots de passe correspondent."
        } else {
            "Les mots de passe ne correspondent pas ou sont trop courts."
        }
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}