package com.example.crud;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName, editTextAge, editTextId;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextId = findViewById(R.id.editTextId);
        Button addButton = findViewById(R.id.addButton);
        Button updateButton = findViewById(R.id.updateButton);
        Button deleteButton = findViewById(R.id.deleteButton);
        Button viewButton = findViewById(R.id.viewButton);

        dbHelper = new DatabaseHelper(this);

        addButton.setOnClickListener(view -> insertUser());
        updateButton.setOnClickListener(view -> updateUser());
        deleteButton.setOnClickListener(view -> deleteUser());
        viewButton.setOnClickListener(view -> viewUser());
    }

    private void insertUser() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, editTextName.getText().toString());
        values.put(DatabaseHelper.COLUMN_AGE, Integer.parseInt(editTextAge.getText().toString()));

        long id = db.insert(DatabaseHelper.TABLE_USERS, null, values);
        if (id != -1) {
            Toast.makeText(this, "User added, ID: " + id, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error adding user", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateUser() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, editTextName.getText().toString());
        values.put(DatabaseHelper.COLUMN_AGE, Integer.parseInt(editTextAge.getText().toString()));

        int rows = db.update(DatabaseHelper.TABLE_USERS, values, DatabaseHelper.COLUMN_ID + " = ?", new String[]{editTextId.getText().toString()});
        if (rows > 0) {
            Toast.makeText(this, "User updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error updating user", Toast.LENGTH_SHORT).show();
        }
    }

    private void deleteUser() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int rows = db.delete(DatabaseHelper.TABLE_USERS, DatabaseHelper.COLUMN_ID + " = ?", new String[]{editTextId.getText().toString()});
        if (rows > 0) {
            Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error deleting user", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewUser() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(DatabaseHelper.TABLE_USERS, new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_AGE},
                DatabaseHelper.COLUMN_ID + " = ?", new String[]{editTextId.getText().toString()}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String user = "ID: " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID)) +
                    ", Name: " + cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)) +
                    ", Age: " + cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_AGE));
            Toast.makeText(this, user, Toast.LENGTH_LONG).show();
            cursor.close();
        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
        }
    }
}
