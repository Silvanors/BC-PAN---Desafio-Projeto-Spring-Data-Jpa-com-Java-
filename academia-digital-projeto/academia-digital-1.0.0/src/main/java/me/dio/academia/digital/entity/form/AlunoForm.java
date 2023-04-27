package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Preecha o campo corretamente.") //anotação para uso em Strings
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max}  caracteres.")
  private String nome;

  @NotBlank(message = "Preecha o campo corretamente.") //anotação para uso em Strings
  @Size(message = "'${validatedValue}' é inválido!")
  private String cpf;

  @NotBlank(message = "Preecha o campo corretamente.") //anotação para uso em Strings
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max}  caracteres.")
  private String bairro;

  @NotNull(message = "Preecha o campo corretamente.") //anotação para uso em Strings
  @Past(message = "'${validatedValue}' é inválido!") //anotação @Past para aceitar somente datas do passado.
  private LocalDate dataDeNascimento;
}
