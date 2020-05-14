package com.xdev.diceroller

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var diceImageOne: ImageView
    private lateinit var diceImageTwo: ImageView
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        diceImageOne = findViewById(R.id.dice_image_one)
        diceImageTwo = findViewById(R.id.dice_image_two)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }


    }


    private fun rollDice() {
        mp = MediaPlayer.create(this, R.raw.rolling_dic)
        mp.start()
        val randomIntOne = Random.nextInt(6) + 1
        val randomIntTwo = Random.nextInt(6) + 1

        diceImageOne.setImageResource(prepareImageFromInt(randomIntOne))
        diceImageTwo.setImageResource(prepareImageFromInt(randomIntTwo))

    }

    private fun prepareImageFromInt(randomInt: Int): Int {
        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
