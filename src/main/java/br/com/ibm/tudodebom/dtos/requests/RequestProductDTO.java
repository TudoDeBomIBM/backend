package br.com.ibm.tudodebom.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RequestProductDTO {

	@NotBlank
    @Size(max=50, message="O atributo nome deve conter no máximo 50 caracteres")
	private String nome;
	@NotBlank
    @Size(max=50, message="O atributo descrição deve conter no máximo 100 caracteres")
	private String descricao;
	@NotNull
	private Double preco_unit;
	@NotNull
	private int estoque;
	@NotBlank
    @Size(max=1, message="O atributo flag_remedio deve conter no máximo 1 caracter")
	private String flag_remedio;
	@NotBlank
    @Size(max=1, message="O atributo flag_generico deve conter no máximo 1 caracter")
	private String flag_generico;
	
}
