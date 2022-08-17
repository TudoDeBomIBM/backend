package br.com.ibm.tudodebom.dtos.requests;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class RequestProductDTO {
	private Long id;
    @NotEmpty
    private String name;
    @DateTimeFormat
    private Date createdAt;
    @NotNull
    private Boolean isMedicine;
    @NotNull
    private Boolean isGeneric;
    private int quantity;

}