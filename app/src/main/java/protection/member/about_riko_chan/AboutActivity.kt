package protection.member.about_riko_chan

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import protection.member.about_riko_chan.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    private lateinit var image: ImageView
    private lateinit var name: TextView
    private lateinit var background: TextView
    private lateinit var personality: TextView
    private lateinit var unit: ImageView
    private lateinit var subunit: ImageView
    private lateinit var school: TextView
    private lateinit var schoolYears: TextView
    private lateinit var birthday: TextView
    private lateinit var astrological: TextView
    private lateinit var bloodType: TextView
    private lateinit var height: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        image = binding.imageFace
        name = binding.name
        background = binding.background
        personality = binding.personality
        unit = binding.logoUnit
        subunit = binding.logoSubunit
        school = binding.school
        schoolYears = binding.schoolYears
        birthday = binding.birthday
        astrological = binding.astrological
        bloodType = binding.bloodType
        height = binding.height

        addAll()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this@AboutActivity, "Go back to Home", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun addAll() {
        image.setImageResource(R.drawable.face)
        name.text = buildString {
            append("Sakurauchi Riko")
        }

        background.text = buildString {
            append("Riko-chan is a second year transfer student from Otonokizaka High School, who joined ")
            append("Uranohoshi after moving from Akihabara, Tokyo. She is in Chika-chan's class and is also neighbors with her.\n\n")
            append("When Riko-chan lived in Tokyo, she used to play the piano, practicing in the same room ")
            append("as former student and μ's member Nishikino Maki did at Otonokand is finally expanded upon in Season 2 Episode 5. After she and Yoshiko chool idol with her and ")
            append("You-chan, in hopes it would inspire Riko-chan.")
        }

        personality.text = buildString {
            append("Riko-chan is a reserved, kind, polite and modest girl who likes indoor activities, acting as ")
            append("a foil to her friends, the more energetic Chika-chan and You-chan. She is rather shy, ")
            append("but is nevertheless affable and friendly. However, while she is generally quite levelheaded, ")
            append("calm and mature, she often flies into a panic when under pressure, jumping to ")
            append("conclusions and making mistakes. Because of this, and a previous incident on which ")
            append("she failed to play the piano in front of a live audience, she doesn't think she's special, ")
            append("and doesn't want to become a school idol. However, her friend Chika-chan drags ")
            append("her into it, in the hopes this would inspire her to keep playing the piano.\n\n")

            append("In spite of her quiet and reserved personality, Riko-chan has cynophobia: she loses her calm when ")
            append("she sees a dog (or anything she deems similar to one), to the point of moving recklessly ")
            append("when faced with one directly. This is commonly seen throughout most of Season 1 (starting with Episode 2) ")
            append("and is finally expanded upon in Season 2 Episode 5. After she and Yoshiko-chan temporarily take care of a dog ")
            append("in the same episode, her fear of dogs is revoked and she eventually understands she likes them, getting her own in Season 2 Episode 13.\n\n")

            append("Riko-chan can also be quite playful and dorky, this is especially seen with Chika-chan, an example being when she copies Chika-chan's \"normal monster\"")
            append("act to help Chika-chan combat her hopelessness in Season 2 Episode 1. Additionally, after the events of Season 2 Episode 5, her interactions")
            append("with Yoshiko-chan causes Riko-chan to start acting like her at times and be called \"Lili\" (Riri) by her, which annoys Riko-chan. (This name is derived from")
            append("Lilith, a demon in Jewish mythology, and is also the double pronunciation of the first syllable of her name.)")
        }

        unit.setImageResource(R.drawable.aqours)
        subunit.setImageResource(R.drawable.guilty_kiss)

        school.text = buildString {
            append("Uranohoshi Girls' High School")
        }

        schoolYears.text = buildString {
            append("2nd years")
        }

        birthday.text = buildString {
            append("September 19")
        }

        astrological.text = buildString {
            append("virgo")
        }

        bloodType.text = buildString {
            append("A")
        }

        height.text = buildString {
            append("1m 60cm")
        }
    }
}