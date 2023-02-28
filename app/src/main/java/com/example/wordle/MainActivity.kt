package com.example.wordle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var wordToGuess=FourLetterWordList.getRandomFourLetterWord()
    var count=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var guessButton = findViewById<Button>(R.id.button2)
        var guessInput = findViewById<EditText>(R.id.et_simple)



        var firstguess = findViewById<TextView>(R.id.textView9)
        var firstguessCheck = findViewById<TextView>(R.id.textView10)
        var secondguess = findViewById<TextView>(R.id.textView11)
        var secondguessCheck = findViewById<TextView>(R.id.textView12)
        var thirdguess = findViewById<TextView>(R.id.textView13)
        var thirdguessCheck = findViewById<TextView>(R.id.textView14)

        var correctGuess = findViewById<TextView>(R.id.textView7)

        guessButton.setOnClickListener {
            count+=1
            var userGuess = guessInput.text.toString().uppercase()

            firstguess.text = userGuess
            firstguessCheck.text = checkGuess(userGuess)


            guessButton.setOnClickListener {
//                count+=1
                var userGuess = guessInput.text.toString().uppercase()

                secondguess.text = userGuess
                secondguessCheck.text = checkGuess(userGuess)


                guessButton.setOnClickListener {
//                    count+=1
                    var userGuess = guessInput.text.toString().uppercase()

                    thirdguess.text = userGuess
                    thirdguessCheck.text = checkGuess(userGuess)


                }

            }

        }

        if (count==1){
            correctGuess.text=wordToGuess.toString()
        }


        }



    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

        }










