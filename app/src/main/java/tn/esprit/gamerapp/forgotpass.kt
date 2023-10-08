package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class forgotpass : AppCompatActivity() {

    private lateinit var editEmail: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonSendSMS: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)

        /*
            editEmail = findViewById(R.id.editText1)
            buttonSubmit = findViewById(R.id.button2)
            buttonSendSMS = findViewById(R.id.textView8)

            // Désactiver les boutons au démarrage
            buttonSubmit.isEnabled = true
            buttonSendSMS.isEnabled = true

            setupSubmitButton()
            setupSendSMSButton()
            setupAutoValidation()
        }

        private fun setupSubmitButton() {
            buttonSubmit.setOnClickListener {
                val enteredEmail = editEmail.text.toString()

                if (isValidEmail(enteredEmail)) {
                    // Si l'e-mail est valide, naviguer vers OTPValidationActivity avec le code spécifié (1234)
                    navigateToOTPValidationActivity("1234")
                } else {
                    // Si les données ne sont pas valides, afficher un Snackbar avec un message d'erreur
                    Snackbar.make(it, "E-mail invalide", Snackbar.LENGTH_LONG).show()
                }
            }
        }

        private fun setupSendSMSButton() {
            buttonSendSMS.setOnClickListener {
                val enteredEmail = editEmail.text.toString()

                if (isValidEmail(enteredEmail)) {
                    // Si l'e-mail est valide, naviguer vers OTPValidationActivity avec le code 6789
                    navigateToOTPValidationActivity("6789")
                } else {
                    // Si les données ne sont pas valides, afficher un Snackbar avec un message d'erreur
                    Snackbar.make(it, "E-mail invalide", Snackbar.LENGTH_LONG).show()
                }
            }
        }

        private fun setupAutoValidation() {
            editEmail.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val enteredEmail = s.toString()

                    if (isValidEmail(enteredEmail)) {
                        // Si l'e-mail est valide, activer les boutons
                        buttonSubmit.isEnabled = true
                        buttonSendSMS.isEnabled = true
                    } else {
                        // Si l'e-mail n'est pas valide, désactiver les boutons
                        buttonSubmit.isEnabled = false
                        buttonSendSMS.isEnabled = false
                    }
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }

        private fun isValidEmail(email: String): Boolean {
            // Vérification de l'e-mail (vous pouvez personnaliser cette logique)
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        private fun navigateToOTPValidationActivity(code: String) {
            // Naviguer vers OTPValidationActivity avec le code spécifié
            val intent = Intent(this, validerpass::class.java)
            intent.putExtra("code", code)
            startActivity(intent)*/

        //navigation submit button
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            // Créer un Intent pour naviguer vers OTPValidationActivity
            val intent = Intent(this, validerpass::class.java)

            // Ajouter le code OTP (1234) en tant que donnée supplémentaire dans l'Intent
            val otpCode = "1234"
            intent.putExtra("otpCode", otpCode)

            // Démarrer l'activité OTPValidationActivity
            startActivity(intent)
        }

        //navigation submit button




    }
}