package protection.member.about_riko_chan

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import protection.member.about_riko_chan.databinding.ActivityChooseImageBinding

class ChooseImageActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityChooseImageBinding

    private lateinit var clothesRadioGroup: RadioGroup
    private lateinit var saveButton: MaterialButton

    companion object {
        const val EXTRA_IMAGE = "0"
        const val RESULT_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        clothesRadioGroup = binding.clothesRadioGroup
        saveButton = binding.saveButton

        saveButton.setOnClickListener(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this@ChooseImageActivity, "Go back to Home", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        if (v?.id != R.id.save_button || clothesRadioGroup.checkedRadioButtonId <= 0)
            return

        var imagePhoto: Int? = null
        when (clothesRadioGroup.checkedRadioButtonId) {
            R.id.summer_uniform -> imagePhoto = R.drawable.summer_uniform
            R.id.winter_uniform -> imagePhoto = R.drawable.winter_uniform
            R.id.summer_private -> imagePhoto = R.drawable.summer_private
            R.id.winter_private -> imagePhoto = R.drawable.winter_private
            R.id.summer_noble -> imagePhoto = R.drawable.noble_summer
            R.id.winter_noble -> imagePhoto = R.drawable.noble_winter
        }

        val resultIntent = Intent()
        resultIntent.putExtra(EXTRA_IMAGE, imagePhoto)
        setResult(RESULT_CODE, resultIntent)
        finish()
    }
}