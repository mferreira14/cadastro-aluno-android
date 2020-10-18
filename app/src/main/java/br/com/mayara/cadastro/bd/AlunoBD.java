package br.com.mayara.cadastro.bd;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import br.com.mayara.cadastro.model.Aluno;

public class AlunoBD extends Application {

        private List<Aluno> alunos = new ArrayList<>();

        public List<Aluno> getAlunos() {
            return alunos;
        }

        public void setAlunos(List<Aluno> alunos) {
            this.alunos = alunos;
        }
    }

