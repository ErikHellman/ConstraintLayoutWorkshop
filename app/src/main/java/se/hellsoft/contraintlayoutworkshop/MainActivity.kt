package se.hellsoft.contraintlayoutworkshop

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
  companion object {
    private const val MAX_MESSAGE_LENGTH = 200
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    progressBar.max = MAX_MESSAGE_LENGTH
    messageInput.addTextChangedListener(object: TextWatcher {
      override fun afterTextChanged(editable: Editable?) {
        val text = editable?.toString() ?: ""
        messagePreview.text = text
        progressBar.progress = text.length
      }

      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      }
    })
  }
}
