package br.com.ibm.tudodebom.dtos.requests;

import java.math.BigDecimal;

import br.com.ibm.tudodebom.entities.OrderEntity;
import lombok.Data;

@Data
public class RequestOrderDetailsDTO {
	private Long id;
	private RequestOrderDTO order;
	private RequestProductDTO product;
	private BigDecimal unityPrice;
	private Integer quantity;
	private BigDecimal totalPrice;
}
