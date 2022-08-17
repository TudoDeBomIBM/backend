package br.com.ibm.tudodebom.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class RequestClientDTO {
	private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String senha;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
}
