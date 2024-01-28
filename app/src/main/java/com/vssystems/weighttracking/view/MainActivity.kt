package com.vssystems.weighttracking.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.ViewCompat.setActivated
import com.vssystems.weighttracking.databinding.ActivityMainBinding
import ru.cleverpumpkin.calendar.CalendarDate
import ru.cleverpumpkin.calendar.CalendarView
import ru.cleverpumpkin.calendar.extension.getColorInt
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setCalendar()
        calendarClick()
        btnSaveClick()
    }

    private fun setCalendar() {
        with(binding) {
            val calendar = Calendar.getInstance()

            calendar.set(2024, Calendar.JANUARY, Calendar.DAY_OF_WEEK)
            val initialDate = CalendarDate(calendar.time)

            calendar.set(2024, Calendar.JANUARY, 1)
            val minDate = CalendarDate(calendar.time)

            val firstDayOfWeek = Calendar.SUNDAY

            calendarView.setupCalendar(
                initialDate = initialDate,
                minDate = minDate,
                selectionMode = CalendarView.SelectionMode.SINGLE,
                firstDayOfWeek = firstDayOfWeek,
                showYearSelectionView = true
            )
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun calendarClick() {
        with(binding) {
            calendarView.onDateClickListener = { date ->
                val selectedDate = calendarView.selectedDate
                Toast.makeText(applicationContext, "${selectedDate.toString()} selected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btnSaveClick() {
        with(binding) {
            btnSave.setOnClickListener{
                Toast.makeText(applicationContext, "test", Toast.LENGTH_SHORT).show()
            }
        }
    }


}