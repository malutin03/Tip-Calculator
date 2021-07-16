                                                                                                                                                            package org.hyperskill.calculator.tip

//import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
//import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mEditText = findViewById<EditText>(R.id.edit_text)
        val mTextView = findViewById<TextView>(R.id.text_view)
        val mSlider = findViewById<Slider>(R.id.slider)
        var newPercent = "0"
        var newPay = ""
        var tipAmount = 0.0F

        mEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                newPay = s?.toString() ?: ""
                //R.id.text_view.makeText(this, "$new", R.id.text_view.LENGTH_SHORT).show()
                if (newPay.isEmpty()) {
                    mTextView.setText("")
                } else {
                    tipAmount = newPay.toFloat() * newPercent.toInt() / 100
//                    mTextView.setText("Bill value: $newPay, tip percentage: $newPercent%")
//                    mTextView.setText("$newPercent% tip: $tipAmount")
                    mTextView.setText("Tip amount: %.2f".format(tipAmount))
                }
            }

        })

        mSlider.addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                newPercent = value.toInt().toString()
                if (newPay.isEmpty()) {
                    mTextView.setText("")
                } else {
                    tipAmount = newPay.toFloat() * newPercent.toInt() / 100
//                    mTextView.setText("Bill value: $newPay, tip percentage: $newPercent%")
//                    mTextView.setText("$newPercent% tip: $tipAmount")
                    mTextView.setText("Tip amount: %.2f".format(tipAmount))
//                    mTextView.setText("Tip amount: $sTipAmount")
                }
            }
        })
    }
}