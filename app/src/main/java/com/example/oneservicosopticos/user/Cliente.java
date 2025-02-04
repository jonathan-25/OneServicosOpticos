package com.example.oneservicosopticos.user;

public class Cliente {


    private String id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String endereco;
    private String telefone;
    private String celular;
    private String instagram;
    private String facebook;
    private String nomeMedico;
    private String crmMedico;
    private String esfericoLongeOd;
    private String cilindricoLongeOd;
    private String eixoLongeOd;
    private String esfericoLongeOe;
    private String cilindricoLongeOe;
    private String eixoLongeOe;
    private String adicaoOd;
    private String adicaoOe;
    private String esfericoPertoOd;
    private String esfericoPertoOe;
    private String cilindricoPertoOd;
    private String cilindricoPertoOe;
    private String eixoPertoOd;
    private String eixoPertoOe;
    private boolean dominante;
    private String dnpD;
    private String dnpE;
    private String alturaD;
    private String alturaE;
    private String prismaD;
    private String prismaE;
    private String eixoPrismaD;
    private String eixoPrismaE;


    public Cliente() {
    }


    public Cliente(String eixoPrismaE, String eixoPrismaD, String prismaE, String prismaD, String alturaE, String alturaD, String dnpE, String dnpD, boolean dominante, String eixoPertoOe, String eixoPertoOd, String cilindricoPertoOe, String cilindricoPertoOd, String esfericoPertoOe, String esfericoPertoOd, String adicaoOe, String adicaoOd, String eixoLongeOe, String cilindricoLongeOe, String esfericoLongeOe, String eixoLongeOd, String cilindricoLongeOd, String esfericoLongeOd, String crmMedico, String nomeMedico, String facebook, String instagram, String celular, String telefone, String endereco, String email, String cpf, String sobrenome, String nome, String id) {
        this.eixoPrismaE = eixoPrismaE;
        this.eixoPrismaD = eixoPrismaD;
        this.prismaE = prismaE;
        this.prismaD = prismaD;
        this.alturaE = alturaE;
        this.alturaD = alturaD;
        this.dnpE = dnpE;
        this.dnpD = dnpD;
        this.dominante = dominante;
        this.eixoPertoOe = eixoPertoOe;
        this.eixoPertoOd = eixoPertoOd;
        this.cilindricoPertoOe = cilindricoPertoOe;
        this.cilindricoPertoOd = cilindricoPertoOd;
        this.esfericoPertoOe = esfericoPertoOe;
        this.esfericoPertoOd = esfericoPertoOd;
        this.adicaoOe = adicaoOe;
        this.adicaoOd = adicaoOd;
        this.eixoLongeOe = eixoLongeOe;
        this.cilindricoLongeOe = cilindricoLongeOe;
        this.esfericoLongeOe = esfericoLongeOe;
        this.eixoLongeOd = eixoLongeOd;
        this.cilindricoLongeOd = cilindricoLongeOd;
        this.esfericoLongeOd = esfericoLongeOd;
        this.crmMedico = crmMedico;
        this.nomeMedico = nomeMedico;
        this.facebook = facebook;
        this.instagram = instagram;
        this.celular = celular;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.id = id;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public String getEsfericoLongeOd() {
        return esfericoLongeOd;
    }

    public void setEsfericoLongeOd(String esfericoLongeOd) {
        this.esfericoLongeOd = esfericoLongeOd;
    }

    public String getCilindricoLongeOd() {
        return cilindricoLongeOd;
    }

    public void setCilindricoLongeOd(String cilindricoLongeOd) {
        this.cilindricoLongeOd = cilindricoLongeOd;
    }

    public String getEixoLongeOd() {
        return eixoLongeOd;
    }

    public void setEixoLongeOd(String eixoLongeOd) {
        this.eixoLongeOd = eixoLongeOd;
    }

    public String getEsfericoLongeOe() {
        return esfericoLongeOe;
    }

    public void setEsfericoLongeOe(String esfericoLongeOe) {
        this.esfericoLongeOe = esfericoLongeOe;
    }

    public String getCilindricoLongeOe() {
        return cilindricoLongeOe;
    }

    public void setCilindricoLongeOe(String cilindricoLongeOe) {
        this.cilindricoLongeOe = cilindricoLongeOe;
    }

    public String getEixoLongeOe() {
        return eixoLongeOe;
    }

    public void setEixoLongeOe(String eixoLongeOe) {
        this.eixoLongeOe = eixoLongeOe;
    }

    public String getAdicaoOd() {
        return adicaoOd;
    }

    public void setAdicaoOd(String adicaoOd) {
        this.adicaoOd = adicaoOd;
    }

    public String getAdicaoOe() {
        return adicaoOe;
    }

    public void setAdicaoOe(String adicaoOe) {
        this.adicaoOe = adicaoOe;
    }

    public String getEsfericoPertoOd() {
        return esfericoPertoOd;
    }

    public void setEsfericoPertoOd(String esfericoPertoOd) {
        this.esfericoPertoOd = esfericoPertoOd;
    }

    public String getEsfericoPertoOe() {
        return esfericoPertoOe;
    }

    public void setEsfericoPertoOe(String esfericoPertoOe) {
        this.esfericoPertoOe = esfericoPertoOe;
    }

    public String getCilindricoPertoOd() {
        return cilindricoPertoOd;
    }

    public void setCilindricoPertoOd(String cilindricoPertoOd) {
        this.cilindricoPertoOd = cilindricoPertoOd;
    }

    public String getCilindricoPertoOe() {
        return cilindricoPertoOe;
    }

    public void setCilindricoPertoOe(String cilindricoPertoOe) {
        this.cilindricoPertoOe = cilindricoPertoOe;
    }

    public String getEixoPertoOd() {
        return eixoPertoOd;
    }

    public void setEixoPertoOd(String eixoPertoOd) {
        this.eixoPertoOd = eixoPertoOd;
    }

    public String getEixoPertoOe() {
        return eixoPertoOe;
    }

    public void setEixoPertoOe(String eixoPertoOe) {
        this.eixoPertoOe = eixoPertoOe;
    }

    public boolean isDominante() {
        return dominante;
    }

    public void setDominante(boolean dominante) {
        this.dominante = dominante;
    }

    public String getDnpD() {
        return dnpD;
    }

    public void setDnpD(String dnpD) {
        this.dnpD = dnpD;
    }

    public String getDnpE() {
        return dnpE;
    }

    public void setDnpE(String dnpE) {
        this.dnpE = dnpE;
    }

    public String getAlturaD() {
        return alturaD;
    }

    public void setAlturaD(String alturaD) {
        this.alturaD = alturaD;
    }

    public String getAlturaE() {
        return alturaE;
    }

    public void setAlturaE(String alturaE) {
        this.alturaE = alturaE;
    }

    public String getPrismaD() {
        return prismaD;
    }

    public void setPrismaD(String prismaD) {
        this.prismaD = prismaD;
    }

    public String getPrismaE() {
        return prismaE;
    }

    public void setPrismaE(String prismaE) {
        this.prismaE = prismaE;
    }

    public String getEixoPrismaD() {
        return eixoPrismaD;
    }

    public void setEixoPrismaD(String eixoPrismaD) {
        this.eixoPrismaD = eixoPrismaD;
    }

    public String getEixoPrismaE() {
        return eixoPrismaE;
    }

    public void setEixoPrismaE(String eixoPrismaE) {
        this.eixoPrismaE = eixoPrismaE;
    }
}
