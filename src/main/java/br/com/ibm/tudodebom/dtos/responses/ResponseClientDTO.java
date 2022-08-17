package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

@Data
public class ResponseClientDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
}
