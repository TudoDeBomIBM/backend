package br.com.ibm.tudodebom.dtos.responses;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
public class ResponseOrderDetails {
	private Long id;
	@JsonBackReference
	private ResponseOrderDTO order;
	private ResponseProductDTO product;
	private BigDecimal unityPrice;
	private Integer quantity;
	private BigDecimal totalPrice;
}
