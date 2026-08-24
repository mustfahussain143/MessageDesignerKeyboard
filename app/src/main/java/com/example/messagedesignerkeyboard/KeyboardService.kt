package com.example.messagedesignerkeyboard

import android.inputmethodservice.InputMethodService
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.view.Gravity
import android.view.inputmethod.InputConnection
import android.widget.Button
import android.widget.LinearLayout

class KeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {

        val keyboard = LinearLayout(this)
        keyboard.orientation = LinearLayout.VERTICAL
        keyboard.setPadding(8, 8, 8, 8)
        keyboard.setBackgroundColor(Color.rgb(245, 245, 245))

        addRow(
            keyboard,
            arrayOf("1", "2", "3", "4", "5")
        )

        addRow(
            keyboard,
            arrayOf("6", "7", "8", "9", "0")
        )

        addRow(
            keyboard,
            arrayOf("Hello", "Hi", "Thanks")
        )

        addRow(
            keyboard,
            arrayOf("❤️", "😊", "👍", "🔥")
        )

        return keyboard
    }

    private fun addRow(
        keyboard: LinearLayout,
        texts: Array<String>
    ) {
        val row = LinearLayout(this)
        row.orientation = LinearLayout.HORIZONTAL
        row.gravity = Gravity.CENTER

        for (text in texts) {

            val button = Button(this)
            button.text = text
            button.textSize = 16f

            val params = LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1f
            )

            params.setMargins(4, 4, 4, 4)
            button.layoutParams = params

            button.setOnClickListener {
                currentInputConnection?.commitText(text, 1)
            }

            row.addView(button)
        }

        keyboard.addView(row)
    }
}
