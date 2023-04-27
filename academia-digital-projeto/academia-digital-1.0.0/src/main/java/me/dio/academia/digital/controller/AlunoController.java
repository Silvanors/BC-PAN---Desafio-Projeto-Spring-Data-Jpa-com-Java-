package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



//OBS.: o "Controller" vai chamar o "Service" que vai chamar o "Repository" que terá acesso ao "banco de dados"
@RestController
@RequestMapping("/alunos") //mapeamento: caminho pelo browser só é colocar "localhost:8080/alunos"
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping // para enviar dados
    public Aluno create(@Valid @RequestBody AlunoForm form) {
        //a anotação @Valid é que ativa as validações do formulário
        return service.create(form);
    }

    @GetMapping("/avaliacoes/{id}") // para buscar todas as avaliações do aluno
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
        // "required = false" significa que pode ou não receber o parâmetro
        return service.getAll(dataDeNascimento);
    }
}
