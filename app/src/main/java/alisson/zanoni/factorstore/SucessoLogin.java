package alisson.zanoni.factorstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SucessoLogin extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button btnAvancar;
    private EditText editCurso;
    private EditText editMatricula;
    private EditText editPeriodo;

    String[] fases = {"1° Fase","2° Fase", "3° Fase", "4° Fase", "5° Fase",
                    "6° Fase","7° Fase","8° Fase","9° Fase"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sucesso_login);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        btnAvancar = findViewById(R.id.btnavancar);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

       ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,fases);
       aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(aa);

       btnAvancar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               editCurso = findViewById(R.id.Curso);
               editMatricula = findViewById(R.id.matricula);
               editPeriodo = findViewById(R.id.Periodo);

                String curso = editCurso.getText().toString().trim();
                String matricula = editMatricula.getText().toString().trim();
                String periodo = editPeriodo.getText().toString().trim();

                if(curso.isEmpty()){
                    CharSequence text = "Campo Curso não pode estar em branco!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if(matricula.isEmpty()){
                    CharSequence text = "Campo Matricula não pode estar em branco!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if(periodo.isEmpty()){
                    CharSequence text = "Campo Periodo não pode estar em branco!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{
                    Intent intent = new Intent(SucessoLogin.this, SucessoPreencherInformacoes.class);
                    startActivity(intent);
                    finish();
                }
           }
       });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),fases[i], Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }
}