package com.example.messagedesignerkeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputConnection
import android.widget.LinearLayout
import android.widget.Button

class KeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL

        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL

        val button1 = Button(this)
        button1.text = "Hello"

        button1.setOnClickListener {
            val inputConnection: InputConnection? = currentInputConnection
            inputConnection?.commitText("Hello", 1)
        }

        row.addView(button1)
        layout.addView(row)

        return layout
    }
}
