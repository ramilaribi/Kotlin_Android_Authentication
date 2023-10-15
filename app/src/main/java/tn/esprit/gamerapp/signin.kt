package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
class signin : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        emailEditText = findViewById(R.id.editText1)
        passwordEditText = findViewById(R.id.editTextTextPassword1)

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = s.toString().trim()

                if (email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEditText.error = "Email invalide"
                } else if (email.isEmpty())
                {
                    emailEditText.error = "must be not empty"
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })


        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val password = s.toString()

                if (password.isEmpty()){
                    passwordEditText.error = "must be not empty"
                } else if (password.length < 8) {
                    passwordEditText.error = "Le mot de passe doit avoir au moins 8 caractères"
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        val editTextName = findViewById<EditText>(R.id.editText)
        val editTextEmail = findViewById<EditText>(R.id.editText1)
        val editTextPassword = findViewById<EditText>(R.id.editTextTextPassword1)
        val editTextConfirmPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val buttonSignIn = findViewById<Button>(R.id.button2)
        buttonSignIn.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            // Vérification des données
            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                showSnackbar("You have some errors in your intputs !")
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                showSnackbar("Les mots de passe ne correspondent pas")
                return@setOnClickListener
            }

            // Si tout est OK, naviguer vers LoginActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Ferme cette activité après la navigation
        }


        // PRIVACYPOLICY COMMING SOON
        val registernow = findViewById<TextView>(R.id.textView7)
        //google+facebook
        registernow.setOnClickListener {
            showSnackbar1(it, "coming soon :)")
        }
    }
    private fun showSnackbar1(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }
}