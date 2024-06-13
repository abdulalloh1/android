package com.example.logindemo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.editTextRegisterUsername);
        passwordEditText = findViewById(R.id.editTextRegisterPassword);
        emailEditText = findViewById(R.id.editTextRegisterEmail);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            // Процедура регистрации пользователя
            // Здесь можно реализовать проверку и сохранение данных пользователя
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

            // После регистрации, например, можно переходить к экрану входа или главному экрану
            // Intent intent = new Intent(this, LoginActivity.class);
            // startActivity(intent);
            // finish();
        }
    }
}
