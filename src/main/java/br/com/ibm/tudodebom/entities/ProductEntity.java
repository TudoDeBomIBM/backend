package br.com.ibm.tudodebom.entities;

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
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_produto")
	private Long id;
	@Column(name = "nome_produto")
	private String nome;
	@Column(name = "descricao_produto")
	private String descricao;
	@Column(name = "precoUnit_produto")
	private String preco_unit;
	@Column(name = "estoque_produto")
	private int estoque;
	@Column(name = "flagRemedio_produto")
	private String flag_remedio;
	@Column(name = "flagGenerico_produto")
	private String flag_generico;
}
