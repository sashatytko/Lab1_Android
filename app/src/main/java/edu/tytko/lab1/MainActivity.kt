package edu.tytko.lab1

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.properties.Delegates

const val DICE_ROLL_NUMBER = "dice_roll_number"

// Activity allows the user to roll a dice and see the result value
class MainActivity : AppCompatActivity() {

    private var diceRoll by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        if (savedInstanceState != null) {
            diceRoll = savedInstanceState.getInt(DICE_ROLL_NUMBER)
            setDice()
        }
    }

    // Roll the dice and show the proper image
    private fun rollDice() {
        // Create dice object and make roll the dice
        val dice = Dice(6)
        diceRoll = dice.roll()

        setDice()
    }

    private fun setDice() {
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(DICE_ROLL_NUMBER, diceRoll)
    }
}