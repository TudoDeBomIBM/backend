package br.com.ibm.tudodebom.dtos.responses;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ResponseOrderDTO {
	 private Long id;
     private ResponseClientDTO client;
     @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
     private Date createdAt;
     private BigDecimal orderPrice;
     private List<ResponseOrderDetails> orderDetails;
}