package br.com.ibm.tudodebom.dtos.requests;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class RequestOrderDTO {
         private Long id;
        private RequestClientDTO client;
        @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
        private Date createdAt;
        private BigDecimal orderPrice;
        private List<RequestOrderDetailsDTO> orderDetails;
}