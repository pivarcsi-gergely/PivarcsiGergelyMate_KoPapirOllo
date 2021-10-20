package hu.petrik.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView teKep, gepKep;
    private TextView emberScore, gepScore;
    private int emberScoreSzam, gepScoreSzam, teTipp, gepTipp;
    private Button buttonKo, buttonPapir, buttonOllo;
    private Toast piritos;
    private AlertDialog.Builder customDialog;
    private Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.rock);
                teTipp = 0;
                gepSorsol();
                kiNyerEgyFordulot();
                dialogElohivas();
            }
        });

        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.paper);
                teTipp = 1;
                gepSorsol();
                kiNyerEgyFordulot();
                dialogElohivas();
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teKep.setImageResource(R.drawable.scissors);
                teTipp = 2;
                gepSorsol();
                kiNyerEgyFordulot();
                dialogElohivas();
            }
        });

    }

    public void gepSorsol(){

        if (gepTipp == 0){
            gepKep.setImageResource(R.drawable.rock);
            gepTipp = r.nextInt(3);
        }
        else if (gepTipp == 1){
            gepKep.setImageResource(R.drawable.paper);
            gepTipp = r.nextInt(3);
        }
        else{
            gepKep.setImageResource(R.drawable.scissors);
            gepTipp = r.nextInt(3);
        }
    }

    public void kiNyerEgyFordulot(){
        if(teTipp == 0 && gepTipp == 1){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "A gép nyert, de sebaj, próbáld újra!", Toast.LENGTH_SHORT).show();
        }
        else if(teTipp == 0 && gepTipp == 2){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "Te nyertél, csak így tovább!", Toast.LENGTH_SHORT).show();
        }
        else if(teTipp == 1 && gepTipp == 0){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "Te nyertél, csak így tovább!", Toast.LENGTH_SHORT).show();
        }
        else if(teTipp == 2 && gepTipp == 0){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "A gép nyert, de sebaj, próbáld újra!", Toast.LENGTH_SHORT).show();
        }
        else if(teTipp == 2 && gepTipp == 1){
            emberScoreSzam++;
            emberScore.setText("Ember: " + emberScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "Te nyertél, csak így tovább!", Toast.LENGTH_SHORT).show();
        }
        else if(teTipp == 1 && gepTipp == 2){
            gepScoreSzam++;
            gepScore.setText("Computer: " + gepScoreSzam);
            piritos.show();
            Toast.makeText(getApplicationContext(), "A gép nyert, de sebaj, próbáld újra!", Toast.LENGTH_SHORT).show();
        }
    }

    public void dialogElohivas(){
        if (emberScoreSzam == 3 || gepScoreSzam == 3){

            if (emberScoreSzam == 3){
                customDialog.setTitle("Győzelem").create().show();
                ujra();
            }
            else if(gepScoreSzam == 3){
                customDialog.setTitle("Vereség").create().show();
                ujra();
            }
        }
    }

    private void ujra() {
        teTipp = 0;
        gepTipp = r.nextInt(3);
        emberScore.setText("Ember: 0");
        gepScore.setText("Computer: 0");
        emberScoreSzam = 0;
        gepScoreSzam = 0;
        teKep.setImageResource(R.drawable.rock);
        gepKep.setImageResource(R.drawable.rock);
    }

    public void init(){
        r = new Random();
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
        piritos = new Toast(getApplicationContext());
        customPiritos();
        //Log.d("gepTipp", String.valueOf(gepTipp));

        customDialog = new AlertDialog.Builder(this);
        DialogKrealo();
    }

    private void DialogKrealo() {
        customDialog.setMessage("Szeretne új játékot játszani?");
        customDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        customDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujra();
                closeContextMenu();
            }
        });
        customDialog.setCancelable(false);
    }

    public void customPiritos(){
        piritos.setDuration(Toast.LENGTH_SHORT);
        View view = getLayoutInflater().inflate(R.layout.piritos, findViewById(R.id.customPiritos));
        piritos.setView(view);
        piritos.setGravity(Gravity.CENTER, 0, 0);
    }


}
