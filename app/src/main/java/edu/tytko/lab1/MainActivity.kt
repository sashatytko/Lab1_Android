package edu.tytko.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

// Activity allows the user to roll a dice and see the result value
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    // Roll the dice and show the proper image
    private fun rollDice() {
        // Create dice object and make roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Determine which drawable to use based on the dice
        val diceImage = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Find the dice image view
        val diceImageView: ImageView = findViewById(R.id.imageView)

        // Update dice image with new dice roll
        diceImageView.setImageResource(diceImage)
        // Update dice image description with new dice roll
        diceImageView.contentDescription = diceRoll.toString()
    }
}