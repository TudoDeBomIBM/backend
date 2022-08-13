package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

@Data
public class ResponseProductDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private String preco_unit;
	private int estoque;
	private String flag_remedio;
	private String flag_generico;
}
