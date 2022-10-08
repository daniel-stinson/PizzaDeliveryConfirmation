package com.example.dslab08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_thanks.*

class Thanks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
        nameId.text=intent.getStringExtra("name")
        phoneId.text=intent.getStringExtra("phoneNumber")
        sizeId.text=intent.getStringExtra("pizzaSize")
        dateId.text=intent.getStringExtra("pickupDate")
        timeId.text=intent.getStringExtra("pickupTime")

        sendBtn.setOnClickListener{
            rateText.text=ratingBar.rating.toString()
        }
    }
}