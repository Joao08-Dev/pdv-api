package com.pdv.model;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Ingrediente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
        @NotBlank
	String nome;
	@NotBlank
	String unidadeMedida;
	@NotNull
	BigDecimal precoUnitario;
        @NotNull
        BigDecimal quantidadeEstoque;

}
