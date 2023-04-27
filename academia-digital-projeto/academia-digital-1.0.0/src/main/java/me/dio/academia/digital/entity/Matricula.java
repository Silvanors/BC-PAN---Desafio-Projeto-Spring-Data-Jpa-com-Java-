package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data // @Data para utilizar o getter, setter, equal e hashCode
@NoArgsConstructor //Criar o construtor vazio pq Hibernate precisa que seja criado o construtor vazio
@AllArgsConstructor //Cria um construtor com os atributos desta classe id, nome, cpf, bairro, dataDeNascimento
@Entity // para persistência do banco de dados: ela diz que a classe aluno é uma tabela
@Table(name = "tb_matriculas") //dando nome a tabela
public class Matricula {

  @Id // idendificando id como chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar a chave primária
  private Long id;

  @OneToOne(cascade = CascadeType.ALL) //com a regra de uma matrícula para um aluno
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
