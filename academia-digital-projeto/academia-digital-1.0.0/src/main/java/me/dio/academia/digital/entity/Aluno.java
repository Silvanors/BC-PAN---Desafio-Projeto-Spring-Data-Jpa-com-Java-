package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data // @Data para utilizar o getter, setter, equal e hashCode
@NoArgsConstructor //Não mostra, mas criar o construtor vazio pq Hibernate precisa que seja criado o construtor vazio
@AllArgsConstructor //Não mostra, mas cria um construtor com os atributos desta classe id, nome, cpf, bairro, dataDeNascimento
@Entity // Cria de fato a tabela no banco de dados.
        // Para persistência do banco de dados: ela diz que a classe aluno é uma tabela.
        // Por padrão pede que toda entidade tenha id pelo @Id.
@Table(name = "tb_alunos") //dando nome a tabela
@JsonIgnoreProperties({"hipernateLazyInitializer", "handler"})
public class Aluno {

  @Id // idendificando id como chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar a chave primária
  private Long id;

  private String nome;

  @Column(unique = true) //colocando unique na coluna cpf (CPF não pode repetir)
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;

@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // para relacionar a tabela/classe "Aluno" com a tabela "AvaliacaoFisica"
           // na relação de um para muitos (relação de cardinalidade)
@JsonIgnore // para ignorar a exception caso apareça
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();


}
