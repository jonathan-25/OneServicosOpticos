package com.example.oneservicosopticos.venda;

import java.util.Date;

public class Venda {

    private String id;
    private String lenteOd;
    private String lenteOe;
    private String peso;
    private String tratamento;
    private String observacoes;
    private String armacao;
    private String observacaoArmacao;
    private String horizontal;
    private String diagonal;
    private String vertical;
    private String ponte;
    private String haste;
    private String serie;
    private String incPantografica;
    private String distVertice;
    private Double valorLenteOd;
    private Double valorLenteOe;
    private Double valorArmacao;
    private Double valorTratamento;
    private Double valorTotal;
    private Date dataVenda;




    public Venda() {
    }


    public Venda(String id, String lenteOd, String lenteOe, String peso, String tratamento, String observacoes, String armacao, String observacaoArmacao, String horizontal, String diagonal, String vertical, String ponte, String haste, String serie, String incPantografica, String distVertice, Double valorLenteOd, Double valorLenteOe, Double valorArmacao, Double valorTratamento, Double valorTotal, Date dataVenda) {
        this.id = id;
        this.lenteOd = lenteOd;
        this.lenteOe = lenteOe;
        this.peso = peso;
        this.tratamento = tratamento;
        this.observacoes = observacoes;
        this.armacao = armacao;
        this.observacaoArmacao = observacaoArmacao;
        this.horizontal = horizontal;
        this.diagonal = diagonal;
        this.vertical = vertical;
        this.ponte = ponte;
        this.haste = haste;
        this.serie = serie;
        this.incPantografica = incPantografica;
        this.distVertice = distVertice;
        this.valorLenteOd = valorLenteOd;
        this.valorLenteOe = valorLenteOe;
        this.valorArmacao = valorArmacao;
        this.valorTratamento = valorTratamento;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLenteOd() {
        return lenteOd;
    }

    public void setLenteOd(String lenteOd) {
        this.lenteOd = lenteOd;
    }

    public String getLenteOe() {
        return lenteOe;
    }

    public void setLenteOe(String lenteOe) {
        this.lenteOe = lenteOe;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getArmacao() {
        return armacao;
    }

    public void setArmacao(String armacao) {
        this.armacao = armacao;
    }

    public String getObservacaoArmacao() {
        return observacaoArmacao;
    }

    public void setObservacaoArmacao(String observacaoArmacao) {
        this.observacaoArmacao = observacaoArmacao;
    }

    public String getHorizontal() {
        return horizontal;
    }

    public void setHorizontal(String horizontal) {
        this.horizontal = horizontal;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getPonte() {
        return ponte;
    }

    public void setPonte(String ponte) {
        this.ponte = ponte;
    }

    public String getHaste() {
        return haste;
    }

    public void setHaste(String haste) {
        this.haste = haste;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIncPantografica() {
        return incPantografica;
    }

    public void setIncPantografica(String incPantografica) {
        this.incPantografica = incPantografica;
    }

    public String getDistVertice() {
        return distVertice;
    }

    public void setDistVertice(String distVertice) {
        this.distVertice = distVertice;
    }

    public Double getValorLenteOd() {
        return valorLenteOd;
    }

    public void setValorLenteOd(Double valorLenteOd) {
        this.valorLenteOd = valorLenteOd;
    }

    public Double getValorLenteOe() {
        return valorLenteOe;
    }

    public void setValorLenteOe(Double valorLenteOe) {
        this.valorLenteOe = valorLenteOe;
    }

    public Double getValorArmacao() {
        return valorArmacao;
    }

    public void setValorArmacao(Double valorArmacao) {
        this.valorArmacao = valorArmacao;
    }

    public Double getValorTratamento() {
        return valorTratamento;
    }

    public void setValorTratamento(Double valorTratamento) {
        this.valorTratamento = valorTratamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
}


