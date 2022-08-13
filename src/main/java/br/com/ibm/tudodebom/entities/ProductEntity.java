package br.com.ibm.tudodebom.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private String preco_unit;
	private int estoque;
	private String flag_remedio;
	private String flag_generico;
}
