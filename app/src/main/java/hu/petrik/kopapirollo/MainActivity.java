package hu.petrik.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView teKep, gepKep;
    private TextView emberScore, gepScore;
    private Button buttonKo, buttonPapir, buttonOllo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void init(){
        teKep = findViewById(R.id.teKep);
        gepKep = findViewById(R.id.gepKep);
        emberScore = findViewById(R.id.emberScore);
        gepScore = findViewById(R.id.gepScore);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
    }
}
