package com.example.dicerollergame

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val images=ArrayList<Int>()
    private val dicesPlayer1=ArrayList<Int>(3)
    private val dicesPlayer2=ArrayList<Int>(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this, "Oyuna hoşgeldiniz\n3 atıştan sonra kazanan belirlenecektir.", Toast.LENGTH_LONG).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonPlayer1:Button = findViewById(R.id.buttonPlayer1)
        val buttonPlayer2:Button = findViewById(R.id.buttonPlayer2)
        val imageViewPlayer1:ImageView = findViewById(R.id.imageViewPlayer1)
        val imageViewPlayer2:ImageView = findViewById(R.id.imageViewPlayer2)

        buttonPlayer1.setOnClickListener {
            var number1=randomNumberGenerate()
            imageViewPlayer1.setImageResource(randomImageGenerate(number1))
            dicesPlayer1.add(number1)
            checkValid()
            println("1 "+number1)


        }
        buttonPlayer2.setOnClickListener {
            var number2=randomNumberGenerate()
            imageViewPlayer2.setImageResource(randomImageGenerate(number2))
            dicesPlayer2.add(number2)
            checkValid()
            println("2 "+number2)
        }
        images.add(R.drawable.dice_0)
        images.add(R.drawable.dice_1)
        images.add(R.drawable.dice_2)
        images.add(R.drawable.dice_3)
        images.add(R.drawable.dice_4)
        images.add(R.drawable.dice_5)
        images.add(R.drawable.dice_6)



    }
    fun randomNumberGenerate():Int{
        return (1..6).random()
    }
    fun randomImageGenerate(deger:Int) : Int {

        return images[deger]
    }
    fun compare(deger1 :Int,deger2:Int){
        println("deger1 "+deger1+" deger2 "+deger2)
            if (deger1 > deger2)
                Toast.makeText(this, "Oyuncu 1 kazandı", Toast.LENGTH_LONG).show()
            else if (deger1 < deger2)
                Toast.makeText(this, "Oyuncu 2 kazandı", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Berabere", Toast.LENGTH_LONG).show()
    }
    fun checkValid(){
        if(dicesPlayer1.size==3 && dicesPlayer2.size==3){

            println("çalıştı")
            var size1=0
            var size2=0
            for (i in 0..2) {
                size1+=dicesPlayer1[i]
                size2+=dicesPlayer2[i]
            }
            println("size1: "+size1+"size2: "+size2)

            compare(size1,size2)
            dicesPlayer1.clear()
            dicesPlayer2.clear()
        }
    }

    }
