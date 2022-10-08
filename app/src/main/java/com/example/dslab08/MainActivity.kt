package com.example.dslab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var slider: SeekBar
        lateinit var value: TextView

        slider=mySeekBar
        value=myPizzaSize
        val pizzaSize=arrayListOf<String>("Please select","Small","Medium", "Large","Extra Large")

        slider.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

                value.text=pizzaSize[p1]

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })

        dateBtn.setOnClickListener{
            val c = Calendar.getInstance()
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            val year = c.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog(this,android.R.style.ThemeOverlay,DatePickerDialog.OnDateSetListener {DatePicker,Year,Month,Day ->
            dateText.text="${Month+1}/ $Day /$Year"},year,month,day)
            myDatePicker.show()

        }

        timeBtn.setOnClickListener{
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR_OF_DAY)
            val minutes = c.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener {TimePicker, hourOfDay,minute ->
                timeText.text="$hourOfDay : $minute" },hour,minutes,false)

            myTimePicker.show()
        }

        scheduleBtn.setOnClickListener{
            var intent = Intent(this,Thanks::class.java)
            intent.putExtra("name",myFullName.text.toString())
            intent.putExtra("phoneNumber",myPhoneNumber.text.toString())
            intent.putExtra("pizzaSize",myPizzaSize.text.toString())
            intent.putExtra("pickupDate",dateText.text.toString())
            intent.putExtra("pickupTime",timeText.text.toString())

            startActivity(intent)
        }
    }
}