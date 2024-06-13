package com.example.seekbar;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.seekbar.R;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textViewValue = findViewById(R.id.textViewValue);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewValue.setText("Value: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Действие при начале перетаскивания ползунка
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Действие при остановке перетаскивания ползунка
            }
        });
    }
}
