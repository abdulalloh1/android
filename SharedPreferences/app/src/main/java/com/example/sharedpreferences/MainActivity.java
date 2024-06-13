package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        Button saveButton = findViewById(R.id.saveButton);
        Button loadButton = findViewById(R.id.loadButton);
        textView = findViewById(R.id.textView);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        saveButton.setOnClickListener(v -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("key_text", editText.getText().toString());
            editor.apply(); // Используйте apply(), а не commit() для асинхронного сохранения
        });

        loadButton.setOnClickListener(v -> {
            String text = sharedPreferences.getString("key_text", "Default Value");
            textView.setText(text);
        });
    }
}
