package com.example.json;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button parseButton = findViewById(R.id.parseButton);
        resultText = findViewById(R.id.resultText);

        parseButton.setOnClickListener(v -> parseJson());
    }

    private void parseJson() {
        try {
            String jsonData = "{\"name\":\"John\", \"age\":30, \"cars\":[\"Ford\", \"BMW\", \"Fiat\"]}";
            JSONObject obj = new JSONObject(jsonData);
            String name = obj.getString("name");
            int age = obj.getInt("age");
            JSONArray cars = obj.getJSONArray("cars");

            StringBuilder result = new StringBuilder();
            result.append("Name: ").append(name).append("\n");
            result.append("Age: ").append(age).append("\n");
            result.append("Cars: ");
            for (int i = 0; i < cars.length(); i++) {
                result.append(cars.getString(i));
                if (i < cars.length() - 1) result.append(", ");
            }

            resultText.setText(result.toString());
        } catch (JSONException e) {
            resultText.setText("Error parsing JSON");
            e.printStackTrace();
        }
    }
}
