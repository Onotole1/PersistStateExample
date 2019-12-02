package com.spitchenko.persiststateexample

import android.os.BaseBundle
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_main.*

private const val PERSIST_KEY = "PERSIST_KEY"
private var BaseBundle.persist: Int
    set(value) = putInt(PERSIST_KEY, value)
    get() = getInt(PERSIST_KEY)

class MainActivity : AppCompatActivity() {
    private var persistValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result.text = persistValue.toString()

        increment_button.setOnClickListener {
            ++persistValue

            result.text = persistValue.toString()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        persistValue = persistentState?.persist ?: persistValue

        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outPersistentState.persist = persistValue
    }
}
