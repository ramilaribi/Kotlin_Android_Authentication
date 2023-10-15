package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Vérifier si les champs sont vides
            if (email.isEmpty() || password.isEmpty()) {
                showSnackbar1("Veuillez remplir tous les champs.")
                return@setOnClickListener
            }

            // Vérifier si l'email est au bon format
            if (!isEmailValid(email)) {
                showSnackbar1("Veuillez saisir un email valide.")
                return@setOnClickListener
            }
            val emailPrefix = extractEmailPrefix(email)
            // Vérifier les identifiants (remplacez par votre logique de vérification)
            if (emailPrefix.isNotEmpty() && password == "password123") {
                // Identifiants valides, lancer l'activité suivante (HomeActivity)
                val intent = Intent(this, home::class.java)
                startActivity(intent)
            } else {
                showSnackbar1("You have some errors in your inputs!.")
            }
        }
      /*  val loginButton: Button = findViewById(R.id.button)
        loginButton.setOnClickListener {
            val emailEditText: EditText = findViewById(R.id.editText)
            val passwordEditText: EditText = findViewById(R.id.editTextTextPassword)

            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (validateLogin(email, password)) {
                // Les données de connexion sont correctes, naviguez vers HomeActivity
                navigateToHomeActivity()
            } else {
                // Affichez un SnackBar avec un message d'erreur
                showSnackBar1("Erreur de connexion")
            }
        }

       */


        emailEditText = findViewById(R.id.editText)
        passwordEditText = findViewById(R.id.editTextTextPassword1)

        val imageButton1 = findViewById<ImageButton>(R.id.imageButton5)
        val imageButton2 = findViewById<ImageButton>(R.id.imageButton6)

        //google+facebook
        imageButton1.setOnClickListener {
            showSnackbar(it, "coming soon :)")
        }

        imageButton2.setOnClickListener {
            showSnackbar(it, "coming soon :) ")
        }
        //google+facebook


        //forgotpass
        val registerTextView1 = findViewById<TextView>(R.id.textView3)
        registerTextView1.setOnClickListener {
            val intent11 = Intent(this, forgotpass::class.java)
            startActivity(intent11) }
        //forgotpass


        //registe now
        val registerTextView = findViewById<TextView>(R.id.textView4)
        registerTextView.setOnClickListener {
            // Navigate to SignUpActivity
            val intent1 = Intent(this, signin::class.java)
            startActivity(intent1)
        }
        //registe now



        emailEditText = findViewById(R.id.editText)
        passwordEditText = findViewById(R.id.editTextTextPassword1)

     // Contrôle de saisie automatique pour l'email
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
            override fun afterTextChanged(s: Editable) {
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
        //**************

    }


 //**************************



    //google+facebook
    private fun showSnackbar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
//google+facebook

    private  fun validateLogin(email: String, password: String): Boolean {
        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.isNotEmpty()
        return isEmailValid && isPasswordValid
    }
    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun showSnackbar1(message: String) {
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_SHORT
        )
        snackbar.show()
    }
    private fun extractEmailPrefix(email: String): String {
        val atIndex = email.indexOf("@")
        return if (atIndex != -1) {
            email.substring(0, atIndex)
        } else {
            ""
        }
    }


    //controle saisie

    //controle saisie
            }







