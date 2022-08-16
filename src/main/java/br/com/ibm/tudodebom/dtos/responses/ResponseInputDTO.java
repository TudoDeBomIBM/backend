package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseInputDTO {
	private Long id;
	private Date dataEntrada;
	private Integer estoque;

}
