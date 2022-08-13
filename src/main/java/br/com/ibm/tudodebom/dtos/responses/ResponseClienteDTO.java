package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

@Data
public class ResponseClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String celular;
    private String endereco;
}
