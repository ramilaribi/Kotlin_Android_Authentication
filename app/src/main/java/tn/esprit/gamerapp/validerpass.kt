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

class validerpass : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText
    private lateinit var buttonValidate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validerpass)


/*
   */
        editText1 = findViewById(R.id.editTextNumberSigned)
        editText2 = findViewById(R.id.editTextNumberSigned1)
        editText3 = findViewById(R.id.editTextNumberSigned2)
        editText4 = findViewById(R.id.editTextNumberSigned3)
        buttonValidate = findViewById(R.id.button2)

        setupOtpInputs()


        buttonValidate.setOnClickListener {
            val enteredOTP = "${editText1.text}${editText2.text}${editText3.text}${editText4.text}"

            // Compare l'OTP saisi avec les valeurs attendues (1234 ou 6789)
            if (enteredOTP == "1234" || enteredOTP == "6789") {
                // OTP correct
                navigateToResetPassword()
            } else {
                // OTP incorrect, afficher un SnackBar avec un message
                showSnackBar("Code OTP incorrect. Veuillez réessayer.")
            }
        }
        val resendnow = findViewById<TextView>(R.id.textView)
        //google+facebook
        resendnow.setOnClickListener {
            showSnackbar1(it, "coming soon :)")
        }
    }
    private fun showSnackbar1(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
    }
    private fun navigateToResetPassword() {
        val intent = Intent(this, resetpass::class.java)
        startActivity(intent)
    }
    private fun showSnackBar(message: String) {
        val snackBar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        snackBar.show()
    }
    private fun setupOtpInputs() {
        // Configuration du changement automatique de focus pour chaque champ OTP
        val editTexts = arrayOf(editText1, editText2, editText3, editText4)

        for (i in editTexts.indices) {
            editTexts[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (s?.length == 1 && i < editTexts.size - 1) {
                        editTexts[i + 1].requestFocus()
                    }
                }

                override fun afterTextChanged(s: Editable?) {}
            })
    }}}
