package com.facens.atividade;

import com.facens.atividade.model.Aluno;
import com.facens.atividade.model.Curso;
import com.facens.atividade.repository.AlunoRepository;
import com.facens.atividade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AtividadeApplication implements CommandLineRunner {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public static void main(String[] args) {
        SpringApplication.run(AtividadeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Curso curso1 = new Curso("Analise e Desenvolvimento de Sistemas (ADS)");
        Curso curso2 = new Curso("Engenharia de Computacao");
        cursoRepository.saveAll(Arrays.asList(curso1, curso2));

        Aluno aluno1 = new Aluno("Thiago", curso1);
        Aluno aluno2 = new Aluno("Maria", curso2);
        alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));

        System.out.println("\n========== DADOS INSERIDOS NO BANCO ==========");
        List<Curso> cursos = cursoRepository.findAll();
        System.out.println("\n--- Cursos Cadastrados ---");
        cursos.forEach(System.out::println);
        List<Aluno> alunos = alunoRepository.findAll();
        System.out.println("\n--- Alunos Cadastrados ---");
        alunos.forEach(System.out::println);
        System.out.println("\n==============================================");
        System.out.println("API rodando: http://localhost:8080/cursos");
        System.out.println("H2 Console:  http://localhost:8080/h2-console");
        System.out.println("==============================================\n");
    }
}