package br.com.mayara.cadastro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.mayara.cadastro.activity.Adapter;
import br.com.mayara.cadastro.activity.RecyclerItemClickListener;
import br.com.mayara.cadastro.bd.AlunoBD;
import br.com.mayara.cadastro.model.Aluno;

public class RecyclerActivity  extends AppCompatActivity {

    private  RecyclerView recyclerView;
    private List<Aluno> listaDeAlunos = new ArrayList<>();
    private Button btnNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recyclerView);

        //Busca dados
        buscaListaDeAlunos();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        //Definindo o Layout
        recyclerView.setLayoutManager(layoutManager);

        //Para ganho de performance quando o layout nao mudar mesmo que o conteudo mude
        recyclerView.setHasFixedSize(true);


        // Para add linhas de separação
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        //Define o Adapter
        Adapter adapter = new Adapter(this.listaDeAlunos);
        recyclerView.setAdapter(adapter);

        //Controle de click
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onItemClick(View view, int position) {
                Aluno aluno = listaDeAlunos.get(position);
                Toast.makeText(
                        getApplicationContext(), aluno.getNome() + ": " + aluno.getMatricula(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {
                Aluno aluno = listaDeAlunos.get(position);
                Toast.makeText(
                        getApplicationContext(), aluno.getNome() + ": " + aluno.getMatricula() + ":" + aluno.getId(), Toast.LENGTH_SHORT).show();
            }
        }
        ));

    }

    public void buscaListaDeAlunos(){
        Intent intent = getIntent();
        final Long id = intent.getLongExtra("id", 0);
        final String nome = intent.getStringExtra("nome");
        final String matricula = intent.getStringExtra("matricula");

        this.listaDeAlunos = ((AlunoBD) this.getApplication()).getAlunos();
        Aluno aluno = new Aluno(id, nome, matricula);
        this.listaDeAlunos.add(aluno);
    }

    public void novo(View view) {

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
