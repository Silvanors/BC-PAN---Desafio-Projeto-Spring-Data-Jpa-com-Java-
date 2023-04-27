package me.dio.academia.digital.repository;

import me.dio.academia.digital.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query(value = "select * from tb_matriculas m" +
                   "Inner Join tb_alunos a ON m.aluno_id = a.id" +
                   "where a.bairro = :bairro", nativeQuery = true) //nativeQuery = true para funcionar
                                                                   // a consulta nativa do banco
    //@Query("FROM Matricula m where m.aluno.bairro = :bairro ") ->funciona também!
    List<Matricula> findAlunosMatriculadosBairro(String bairro);

    //List<Matricula> findByAlunoBairro(String bairro);
}
