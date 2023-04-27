package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaFisicaServiceImpl implements IAvaliacaoFisicaService {


    @Autowired // chamar o AvalicacaoFisicaRepository injetando
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository; //para recuperar o id do aluno em avaliação física

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica(); //criando o objeto avaliacaoFisica
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get(); //busca o aluno pelo id

        avaliacaoFisica.setAluno(aluno); //a informação (id) vem do banco da tabela alunos
        avaliacaoFisica.setPeso(form.getPeso()); //a informação do peso vem do formulário
        avaliacaoFisica.setAltura(form.getAltura()); //a informação do peso vem do formulário


        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return null;
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return null;
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
