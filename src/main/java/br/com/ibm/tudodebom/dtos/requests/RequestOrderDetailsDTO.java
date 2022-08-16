package br.com.ibm.tudodebom.dtos.requests;

import java.math.BigDecimal;

import br.com.ibm.tudodebom.entities.OrderEntity;
import br.com.ibm.tudodebom.entities.ProductEntity;
import lombok.Data;

@Data
public class RequestOrderDetailsDTO {
	private Long id;
	private OrderEntity order;
	private ProductEntity product;
	private BigDecimal unityPrice;
	private Integer quantity;
	private BigDecimal totalPrice;
}
