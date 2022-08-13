package br.com.ibm.tudodebom.dtos.requests;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RequestClienteDTO {
    @NotBlank
    @Size(max=50, message="O atributo nome deve conter no máximo 50 caracteres")
    private String nome;
    @CPF
    @NotBlank
    @Size(min=11, max=11, message="O atributo cpf deve conter 11 caracteres")
    private String cpf;
    @Email
    @NotBlank
    @Size(max=50, message="O atributo email deve conter no máximo 50 caracteres")
    private String email;
    @NotBlank
    @Size(min=8, max=16, message="O atributo senha deve conter entre 8 e 16 caracteres")
    private String senha;
    @NotBlank
    @Size(max=12, message="O atributo celular deve conter 12 caracteres")
    private String celular;
    @NotBlank
    @Size(max=100, message="O atributo endereço deve conter no máximo 100 caracteres")
    private String endereco;
}
