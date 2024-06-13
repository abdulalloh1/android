package com.example.contextmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textViewSample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSample = findViewById(R.id.textViewSample);
        registerForContextMenu(textViewSample);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.add(0, v.getId(), 0, "Action 1");
        menu.add(0, v.getId(), 0, "Action 2");

        // Создание подменю правильным способом
        MenuItem subMenu = menu.addSubMenu("More Actions");
        subMenu.getSubMenu().add("Sub Action 1");
        subMenu.getSubMenu().add("Sub Action 2");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if ("Sub Action 1".equals(item.getTitle())) {
            Toast.makeText(this, "Sub Action 1 selected", Toast.LENGTH_SHORT).show();
        } else if ("Sub Action 2".equals(item.getTitle())) {
            Toast.makeText(this, "Sub Action 2 selected", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
