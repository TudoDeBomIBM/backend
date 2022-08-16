package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseProductDTO {
	private Long id;
	private String nome;
	private Date dataDeCriacao;
	private Boolean isMedicine;
	private Boolean isGeneric;
	private ResponseInputDTO entrada;
	private ResponseOrderDTO pedido;
}
