package de.diskostu.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import de.diskostu.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // the generated binding object
    private lateinit var binding: ActivityMainBinding

    private val dennyName: MyName = MyName("Denny", "diskostu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = dennyName

        // variant 1: use of data binding
        binding.doneButton.setOnClickListener { view ->
            addNickname(view)
        }

        // variant 2: use of kotlin extensions
//        done_button.setOnClickListener { view ->
//            addNickname(view)
//        }
    }

    /**
     * We use data binding in here.
     */
    private fun addNickname(view: View) {
        binding.apply {
            dennyName.nickname = nicknameEdit.text.toString()

            invalidateAll()

            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}