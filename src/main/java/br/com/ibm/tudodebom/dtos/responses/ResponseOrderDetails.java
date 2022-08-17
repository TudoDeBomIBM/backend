package br.com.ibm.tudodebom.dtos.responses;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ResponseOrderDetails {
	private Long id;
	private ResponseOrderDTO order;
	private ResponseProductDTO product;
	private BigDecimal unityPrice;
	private Integer quantity;
	private BigDecimal totalPrice;
}
