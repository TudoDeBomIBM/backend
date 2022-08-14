package br.com.ibm.tudodebom.dtos.requests;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class RequestPedidoDTO {
	
	    @NotBlank
	    @Size(max=3, message="Insira no máximo 3 casas numéricas")
		private int quantidade;
		@NotNull
		private BigDecimal preco_unitario;
		@NotNull
		private BigDecimal preco_final;
		@NotNull
		private BigDecimal desconto;		
		
		

}
