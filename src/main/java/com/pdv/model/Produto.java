package com.pdv.model;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal preco;
    @Column(columnDefinition = "TEXT")
    private String imageBase64;

}
