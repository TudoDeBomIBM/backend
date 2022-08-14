package br.com.ibm.tudodebom.dtos.responses;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ResponsePedidoDTO {
	
	
		private int quantidade;
		private BigDecimal preco_unitario;
		private BigDecimal preco_final;
		private BigDecimal desconto;				

}


