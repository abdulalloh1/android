import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.progressdialogdemo.R;

public class ProgressDialogActivity extends Activity {
    private ProgressBar progressBar;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

        progressBar = findViewById(R.id.progressBar);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProgress();
            }
        });
    }

    private void startProgress() {
        // Здесь можно запустить анимацию или процесс
        // и обновлять прогресс в соответствии с этим процессом.
        // В данном примере мы просто установим произвольное значение прогресса.

        progressBar.setProgress(50); // Установка прогресса на 50% как пример

        Toast.makeText(this, "Progress Started", Toast.LENGTH_SHORT).show();
    }
}
