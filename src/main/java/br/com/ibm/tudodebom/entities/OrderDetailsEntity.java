package br.com.ibm.tudodebom.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "OrderDetails")
public class OrderDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;

	private BigDecimal unityPrice;
	private Integer quantity;
	private BigDecimal totalPrice;
}
