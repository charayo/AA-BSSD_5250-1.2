package com.example.aa_bssd_5250_12

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
    val constraintLayout = ConstraintLayout( this)
        constraintLayout.id = View.generateViewId()
        constraintLayout.setBackgroundColor(Color.WHITE)

    val textView = TextView(this)
    textView.text = "Select Color"
    textView.id = View.generateViewId()

    constraintLayout.addView(textView)
    setContentView(constraintLayout)

    //For the blue button
    val blueButton = Button(this)
    blueButton.text = "BLUE"
    blueButton.id = View.generateViewId()
    blueButton.setBackgroundColor(Color.BLUE)
    blueButton.setOnClickListener(View.OnClickListener {constraintLayout.setBackgroundColor(Color.BLUE) })
    constraintLayout.addView(blueButton)

    //For the red button
    val redButton = Button(this)
    redButton.text = "RED"
    redButton.id = View.generateViewId()
    redButton.setBackgroundColor(Color.RED)
    redButton.setOnClickListener(View.OnClickListener {constraintLayout.setBackgroundColor(Color.RED) })
    constraintLayout.addView(redButton)

    //For the green button
    val greenButton = Button(this)
    greenButton.text = "Green"
    greenButton.id = View.generateViewId()
    greenButton.setBackgroundColor(Color.GREEN)
    greenButton.setOnClickListener(View.OnClickListener {constraintLayout.setBackgroundColor(Color.GREEN) })
    constraintLayout.addView(greenButton)



    //important to constrain everything after the hierarchy has been created
    val constraintSet = ConstraintSet()
    val pid = ConstraintSet.PARENT_ID
    constraintSet.constrainHeight(textView.id, ConstraintSet.WRAP_CONTENT)
    constraintSet.constrainWidth(textView.id, ConstraintSet.WRAP_CONTENT)

    constraintSet.constrainHeight(blueButton.id, ConstraintSet.WRAP_CONTENT)
    constraintSet.constrainWidth(blueButton.id, ConstraintSet.WRAP_CONTENT)

    //for the red button
    constraintSet.constrainHeight(redButton.id, ConstraintSet.WRAP_CONTENT)
    constraintSet.constrainWidth(redButton.id, ConstraintSet.WRAP_CONTENT)

    //for the green button
    constraintSet.constrainHeight(greenButton.id, ConstraintSet.WRAP_CONTENT)
    constraintSet.constrainWidth(greenButton.id, ConstraintSet.WRAP_CONTENT)

   //Match bottom, left, right, and right
    constraintSet.connect(textView.id, ConstraintSet.BOTTOM, pid, ConstraintSet.BOTTOM);
    constraintSet.connect(textView.id, ConstraintSet.TOP, pid, ConstraintSet.TOP);
    constraintSet.connect(textView.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT);
    constraintSet.connect(textView.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT);

    constraintSet.connect(blueButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
    constraintSet.connect(blueButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
    constraintSet.connect(blueButton.id, ConstraintSet.TOP, textView.id, ConstraintSet.BOTTOM)

    // for the red button
    constraintSet.connect(redButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
    constraintSet.connect(redButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
    constraintSet.connect(redButton.id, ConstraintSet.TOP, blueButton.id, ConstraintSet.BOTTOM)

    // for the green button
    constraintSet.connect(greenButton.id, ConstraintSet.LEFT, pid, ConstraintSet.LEFT)
    constraintSet.connect(greenButton.id, ConstraintSet.RIGHT, pid, ConstraintSet.RIGHT)
    constraintSet.connect(greenButton.id, ConstraintSet.TOP, redButton.id, ConstraintSet.BOTTOM)

    constraintSet.applyTo(constraintLayout)
    }
}