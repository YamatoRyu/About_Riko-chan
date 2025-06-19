package protection.member.about_riko_chan

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import protection.member.about_riko_chan.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var chooseImageButton: MaterialButton
    private lateinit var clothesChanges: ImageView

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == ChooseImageActivity.RESULT_CODE && result.data != null) {
            val selectValue = result.data?.getIntExtra(ChooseImageActivity.EXTRA_IMAGE, 0)
            clothesChanges.setImageResource(selectValue!!)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chooseImageButton = binding.clothesButton
        clothesChanges = binding.changesClothes

        chooseImageButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.clothes_button -> {
                Toast.makeText(this@HomeActivity, "All Riko-chan clothes", Toast.LENGTH_LONG).show()
                val intent = Intent(this@HomeActivity, ChooseImageActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.person) {
            Toast.makeText(this@HomeActivity, "About Riko-chan", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@HomeActivity, AboutActivity::class.java)
            startActivity(intent)
        }

        return true
    }
}