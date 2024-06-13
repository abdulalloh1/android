package com.example.alertdialogdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnList = findViewById(R.id.button_list);
        btnList.setOnClickListener(v -> showListDialog());

        Button btnCheck = findViewById(R.id.button_check);
        btnCheck.setOnClickListener(v -> showCheckboxDialog());

        Button btnRadio = findViewById(R.id.button_radio);
        btnRadio.setOnClickListener(v -> showRadioDialog());
    }

    private void showListDialog() {
        final String[] items = {"Item 1", "Item 2", "Item 3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Item");
        builder.setItems(items, (dialog, which) -> {
            // which is the index of the item clicked
            // Handle the item click
        });
        builder.show();
    }

    private void showCheckboxDialog() {
        final String[] items = {"Option 1", "Option 2", "Option 3"};
        boolean[] checkedItems = {true, false, false};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Options");
        builder.setMultiChoiceItems(items, checkedItems, (dialog, which, isChecked) -> {
            // which is the index of the item clicked
            // isChecked is whether the checkbox is now checked
            // Handle the checkbox change
        });
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    private void showRadioDialog() {
        final String[] items = {"Option 1", "Option 2", "Option 3"};
        int checkedItem = 1; // Index of checked item
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose an Option");
        builder.setSingleChoiceItems(items, checkedItem, (dialog, which) -> {
            // which is the index of the item clicked
            // Handle the radio button selection
        });
        builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
        builder.show();
    }
}
