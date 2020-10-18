package br.com.mayara.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtId;
    private EditText edtNome;
    private EditText edtMatricula;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = (EditText) findViewById(R.id.edtId);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtMatricula = (EditText) findViewById(R.id.edtMatricula);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
    }

    public void cadastrar(View view) {

        String idStr = edtId.getText().toString();
        String nome = edtNome.getText().toString();
        String matricula = edtMatricula.getText().toString();

        Long id = Long.valueOf(idStr);

        Toast.makeText(getApplicationContext(), "CADASTRO EFETUADO COM SUCESSO!", Toast.LENGTH_LONG).show(); //vai mostrar em uma caixinha o resultado

        // Chama a segunda view
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("nome",nome);
        intent.putExtra("matricula",matricula);
        startActivity(intent);
    }
}