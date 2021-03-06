package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDices()
        }

        // Do a dice roll when the app starts
        rollDices()

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDices() {
        // Create new Dice object with 6 sides and roll it
        val dice1Roll = Dice(6).roll()
        val dice2Roll = Dice(6).roll()

        // Update the screen with the dice roll
        val diceImage1: ImageView = findViewById(R.id.dice_num_1)
        val diceImage2: ImageView = findViewById(R.id.dice_num_2)

        // Determine which drawable resource ID to use based on the dice roll
        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(changeDrawableResource(dice1Roll))
        diceImage2.setImageResource(changeDrawableResource(dice2Roll))

        // Update the content description
        diceImage1.contentDescription = dice1Roll.toString()
        diceImage2.contentDescription = dice2Roll.toString()
    }

    private fun changeDrawableResource(diceRoll: Int) : Int {
        val drawableResource = when (diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        return drawableResource
    }


}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
