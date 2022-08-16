package br.com.ibm.tudodebom.dtos.responses;

import lombok.Data;

import java.util.Date;

@Data
public class ResponseProductDTO {
    private Long id;
    private String name;
    private Date createdAt;
    private Boolean isMedicine;
    private Boolean isGeneric;
    private int quantity;
}