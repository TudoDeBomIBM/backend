package br.com.ibm.tudodebom.dtos.responses;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.ibm.tudodebom.entities.ClientEntity;
import br.com.ibm.tudodebom.entities.OrderDetailsEntity;
import lombok.Data;

@Data
public class ResponseOrderDTO {
	private Long id;
	private ResponseClientDTO client;
	private Date createdAt;
	private BigDecimal orderPrice;
	private List<ResponseOrderDetails> orderDetails;
}