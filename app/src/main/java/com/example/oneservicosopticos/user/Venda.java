package com.example.oneservicosopticos.user;

import java.util.Date;

public class Venda {

    private String id;
    private String lenteOd;
    private String lenteOe;
    private Boolean pesoD;
    private Boolean pesoE;
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
    private String valorLenteOd;
    private String valorLenteOe;
    private String valorArmacao;
    private String valorTratamento;
    private String valorTotal;
    private Date dataVenda;




    public Venda() {
    }


    public Venda(String id, String lenteOd, String lenteOe, Boolean pesoD, Boolean pesoE, String tratamento, String observacoes, String armacao, String observacaoArmacao, String horizontal, String diagonal, String vertical, String ponte, String haste, String serie, String incPantografica, String distVertice, String valorLenteOd, String valorLenteOe, String valorArmacao, String valorTratamento, String valorTotal, Date dataVenda) {
        this.id = id;
        this.lenteOd = lenteOd;
        this.lenteOe = lenteOe;
        this.pesoD = pesoD;
        this.pesoE= pesoE;
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

    public Boolean getPesoE() {
        return pesoE;
    }

    public void setPesoE(Boolean pesoE) {
        this.pesoE = pesoE;
    }

    public void setLenteOe(String lenteOe) {
        this.lenteOe = lenteOe;
    }

    public Boolean getPesoD() {
        return pesoD;
    }

    public void setPesoD(Boolean pesoD)  {
        this.pesoD = pesoD;
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

    public String getValorLenteOd() {
        return valorLenteOd;
    }

    public void setValorLenteOd(String valorLenteOd) {
        this.valorLenteOd = valorLenteOd;
    }

    public String getValorLenteOe() {
        return valorLenteOe;
    }

    public void setValorLenteOe(String valorLenteOe) {
        this.valorLenteOe = valorLenteOe;
    }

    public String getValorArmacao() {
        return valorArmacao;
    }

    public void setValorArmacao(String valorArmacao) {
        this.valorArmacao = valorArmacao;
    }

    public String getValorTratamento() {
        return valorTratamento;
    }

    public void setValorTratamento(String valorTratamento) {
        this.valorTratamento = valorTratamento;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }


    public void salvarPedido(){



    }

}


