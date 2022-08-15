package br.com.ibm.tudodebom.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

public class EntradaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dataEntrada;
    private BigDecimal precoUnitario;
    private Integer quantidadeEntrada;
}
