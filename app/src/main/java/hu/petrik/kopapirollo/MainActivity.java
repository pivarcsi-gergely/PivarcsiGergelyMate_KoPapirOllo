package hu.petrik.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView teKep, gepKep;
    private TextView emberScore, gepScore;
    private int emberScoreSzam, gepScoreSzam, teTipp, gepTipp;
    private Button buttonKo, buttonPapir, buttonOllo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.rock);
                gepSorsol();
            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.paper);
                gepSorsol();
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.scissors);
                gepSorsol();
            }
        });

    }

    public void gepSorsol(){

        if (gepTipp == 0){
            gepKep.setImageResource(R.drawable.rock);
        }
        else if (gepTipp == 1){
            gepKep.setImageResource(R.drawable.paper);
        }
        else{
            gepKep.setImageResource(R.drawable.scissors);
        }
    }

    public void kiNyerEgyFordulot(){
        if(teTipp == 0 && gepTipp == 1){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
        }
        else if(teTipp == 0 && gepTipp == 2){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
        }
        else if(teTipp == 1 && gepTipp == 0){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
        }
        else if(teTipp == 2 && gepTipp == 0){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
        }
        else if(teTipp == 2 && gepTipp == 1){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
        }
        else if(teTipp == 1 && gepTipp == 2){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
        }
    }

    public void init(){
        Random r = new Random();
        teTipp = 0;
        gepTipp = r.nextInt(3);
        emberScoreSzam = 0;
        gepScoreSzam = 0;
        teKep = findViewById(R.id.teKep);
        gepKep = findViewById(R.id.gepKep);
        emberScore = findViewById(R.id.emberScore);
        gepScore = findViewById(R.id.gepScore);
        buttonKo = findViewById(R.id.buttonKo);
        buttonPapir = findViewById(R.id.buttonPapir);
        buttonOllo = findViewById(R.id.buttonOllo);
    }
}
