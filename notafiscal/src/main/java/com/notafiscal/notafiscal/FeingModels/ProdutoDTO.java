package com.notafiscal.notafiscal.FeingModels;

public class ProdutoDTO {

    private Integer id;
    private String name;
    private Double valor;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String name, Double valor) {
        this.id = id;
        this.name = name;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}