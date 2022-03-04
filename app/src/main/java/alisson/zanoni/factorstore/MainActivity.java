package alisson.zanoni.factorstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private int tempoDeEspera = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trocarTela();

    }

    private void trocarTela() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent trocarDeTela = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(trocarDeTela);
                finish();
            }
        },tempoDeEspera);
    }
}