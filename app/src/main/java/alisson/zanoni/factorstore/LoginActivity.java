package alisson.zanoni.factorstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnEntrar;
    private EditText edtUser;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        btnEntrar = findViewById(R.id.btnENTRAR);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                edtUser = findViewById(R.id.edtUSER);
                edtSenha = findViewById(R.id.edtSENHA);
                String user = edtUser.getText().toString().trim();
                String senha = edtSenha.getText().toString().trim();

                if(user.isEmpty()){
                    CharSequence text = "Campo Login não pode estar em branco!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Log.d("usuario",user);
                } else if(senha.isEmpty()){
                    CharSequence text = "Campo Senha não pode estar em branco!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else if(user.equals("Administrador") && senha.equals("Administrador") || user.equals("Adm") && senha.equals("Adm123") ||
                        user.equals("Administrator") && senha.equals("7410") ||
                        user.equals("Root") && senha.equals("un3scr3m0ta+()")){
                    CharSequence text = "Logado com Sucesso!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Intent intent = new Intent(LoginActivity.this, SucessoLogin.class);
                    startActivity(intent);
                    finish();
                } else {
                    CharSequence text = "Login ou Senha incorretos!";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}