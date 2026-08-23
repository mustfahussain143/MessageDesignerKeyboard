package com.example.messagedesignerkeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout

class KeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val row1 = LinearLayout(this)
        row1.orientation = LinearLayout.HORIZONTAL

        val button1 = Button(this)
        button1.text = "Hello"

        button1.setOnClickListener {
            val inputConnection: InputConnection? = currentInputConnection
            inputConnection?.commitText("Hello", 1)
        }

        val button2 = Button(this)
        button2.text = "Hi"

        button2.setOnClickListener {
            currentInputConnection?.commitText("Hi", 1)
        }

        row1.addView(button1)
        row1.addView(button2)

        layout.addView(row1)

        return layout
    }
}
