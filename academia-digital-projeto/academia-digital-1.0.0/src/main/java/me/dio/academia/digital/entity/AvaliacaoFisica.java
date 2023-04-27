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
@Table(name = "tb_avaliacoes") //dando nome a tabela
public class AvaliacaoFisica {

  @Id // idendificando id como chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // gerar a chave primária
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL) //é o retorno da relação feita na classe "Aluno' e o cascade faz
                                        //qualquer alteração feita aqui ser refletida na Classe Aluno
  @JoinColumn(name = "aluno_id") //juntando as colunas forign key à tabela AvaliacaoFisica
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //para dar nome a coluna no banco
  private double peso;

  @Column(name = "altura_atual") //para dar nome a coluna no banco
  private double altura;

}
