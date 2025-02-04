package com.example.oneservicosopticos.produtos;

public class LentesOfitalmicas {

    String id;
    String nome;
    String tipo;
    String material;
    Double Index;
    Double preco;
    Integer quantidade;
    String fornecedor;


    public LentesOfitalmicas() {
    }


    public LentesOfitalmicas(String id, String nome, String tipo, String material, Double index, Double preco, Integer quantidade, String fornecedor) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.material = material;
        Index = index;
        this.preco = preco;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getIndex() {
        return Index;
    }

    public void setIndex(Double index) {
        Index = index;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }
}
