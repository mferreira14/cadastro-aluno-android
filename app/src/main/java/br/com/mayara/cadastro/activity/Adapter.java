package br.com.mayara.cadastro.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.mayara.cadastro.R;
import br.com.mayara.cadastro.model.Aluno;

public class Adapter extends RecyclerView.Adapter < Adapter.MyViewHolder> {

    private List<Aluno> listaDeAlunos;
    public Adapter (List<Aluno> listaDeAlunos) {this.listaDeAlunos = listaDeAlunos; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemDaLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list, parent, false);
        return new MyViewHolder(itemDaLista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        Aluno alunoLista = listaDeAlunos.get(position);
        holder.txvId.setText(alunoLista.getId().toString());
        holder.txvNome.setText(alunoLista.getNome());
        holder.txvMatricula.setText(alunoLista.getMatricula());
    }

    @Override
    public int getItemCount() { return listaDeAlunos.size();}

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txvId;
        TextView txvNome;
        TextView txvMatricula;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txvId = itemView.findViewById(R.id.txvId);
            txvNome = itemView.findViewById(R.id.txvNome);
            txvMatricula = itemView.findViewById(R.id.txvMatricula);
        }
    }
}


