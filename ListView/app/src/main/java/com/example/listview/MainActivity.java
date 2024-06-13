package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;
    private Button addButton;
    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

        items = new ArrayList<>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        addButton.setOnClickListener(v -> {
            int nextItemNumber = items.size() + 1;
            items.add("Item " + nextItemNumber);
            adapter.notifyDataSetChanged(); // Обновляем адаптер после добавления элемента
        });

        removeButton.setOnClickListener(v -> {
            if (!items.isEmpty()) {
                items.remove(items.size() - 1);
                adapter.notifyDataSetChanged(); // Обновляем адаптер после удаления элемента
            }
        });
    }
}
