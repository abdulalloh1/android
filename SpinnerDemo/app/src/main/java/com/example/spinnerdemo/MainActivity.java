package com.example.spinnerdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.spinnerdemo.R;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        // Создание адаптера с использованием массива строк и стандартного шаблона спиннера
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_data, android.R.layout.simple_spinner_item);
        // Указание шаблона выпадающего списка — используем стандартный
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Присваивание адаптера спиннеру
        spinner.setAdapter(adapter);

        // Обработчик выбора элементов спиннера
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected: " + selected, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }
}
