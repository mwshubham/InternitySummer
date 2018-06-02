package `in`.internity.internitysummer

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class NextActivity : AppCompatActivity() {

    private var mSaveBtn: Button? = null
    private var mNameField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val a = 123
        val b = "2324"


        mSaveBtn = findViewById(R.id.btn_save)
        mNameField = findViewById(R.id.et_name)

        mSaveBtn!!.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("name", mNameField!!.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    companion object {
        private val TAG = "MainActivity"
    }
}
