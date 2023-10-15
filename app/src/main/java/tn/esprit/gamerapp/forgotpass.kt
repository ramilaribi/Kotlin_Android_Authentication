package tn.esprit.gamerapp

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class forgotpass : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val editTextEmail = findViewById<EditText>(R.id.editText1)
            val email = editTextEmail.text.toString().trim()

            if (email.isEmpty() || !isValidEmail(email)) {
                editTextEmail.error = "Veuillez entrer une adresse e-mail valide"
                return@setOnClickListener
            }
            // Créer un Intent pour naviguer vers OTPValidationActivity
            val intent = Intent(this, validerpass::class.java)

            // Ajouter le code OTP (1234) en tant que donnée supplémentaire dans l'Intent
            val otpCode = "1234"
            intent.putExtra("otpCode", otpCode)

            // Démarrer l'activité OTPValidationActivity
            startActivity(intent)
        }
        val buttonsms = findViewById<Button>(R.id.sms)
        buttonsms.setOnClickListener {
            val otpCode = "6789" // Code OTP prédéfini

            // Naviguer vers OTPValidationActivity avec le code OTP prédéfini
            val intent = Intent(this, validerpass::class.java)
            intent.putExtra("otp_code", otpCode)
            startActivity(intent)
        }
    }
    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
