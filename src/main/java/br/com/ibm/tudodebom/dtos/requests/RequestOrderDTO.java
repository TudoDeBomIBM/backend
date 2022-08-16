package br.com.ibm.tudodebom.dtos.requests;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.ibm.tudodebom.entities.ClientEntity;
import br.com.ibm.tudodebom.entities.OrderDetailsEntity;
import lombok.Data;

@Data
public class RequestOrderDTO {
         private Long id;
        private ClientEntity client;
        private Date createdAt;
        private BigDecimal orderPrice;
        private List<OrderDetailsEntity> orderDetails;
}