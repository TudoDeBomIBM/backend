package br.com.ibm.tudodebom.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pedidos")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_itemPedido")
	private Long id;
	@Column(name = "qtd_produtos")
	private int quantidade;
	@Column(name  = "precoUnitario")
	private BigDecimal preco_unitario;
	@Column(name = "precoTotal")
	private BigDecimal preco_final;
	@Column(name = "descontos")
	private BigDecimal desconto;
	@Column(name = "data")
	private Date data;
	

}
