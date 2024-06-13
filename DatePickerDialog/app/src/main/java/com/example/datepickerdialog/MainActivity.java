package com.example.datepickerdialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dateButton = findViewById(R.id.buttonDatePicker);
        Button timeButton = findViewById(R.id.buttonTimePicker);

        dateButton.setOnClickListener(v -> showDatePickerDialog());
        timeButton.setOnClickListener(v -> showTimePickerDialog());
    }

    private void showDatePickerDialog() {
        // Получение текущей даты
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Создание нового DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year1, monthOfYear, dayOfMonth) -> {
                    // Обработка выбора в диалоге
                    String selectedDate = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year1;
                }, year, month, day);
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        // Получение текущего времени
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Создание нового TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minuteOfHour) -> {
                    // Обработка выбора в диалоге
                    String selectedTime = hourOfDay + ":" + minuteOfHour;
                }, hour, minute, true);
        timePickerDialog.show();
    }
}
