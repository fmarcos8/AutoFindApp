package com.example.franciscommarcos.autofind.App.Models;

/**
 * Created by francisco.mmarcos on 15/05/2018.
 */

public class CarModel {
    private String placa;
    private String chassi;
    private String numerofaturado;
    private String anofabricacao;
    private String anomodelo;
    private String marca;
    private String modelo;
    private String cor;
    private String potencia;
    private String cilindradas;
    private String combustivel;
    private String subsegmento;
    private String municipio;
    private String ufmunicipio;
    private String tipoveiculo;

    public CarModel(String placa, String chassi, String numerofaturado, String anofabricacao, String anomodelo, String marca, String modelo, String cor, String potencia, String cilindradas, String combustivel, String subsegmento, String municipio, String ufmunicipio, String tipoveiculo) {
        this.placa = placa;
        this.chassi = chassi;
        this.numerofaturado = numerofaturado;
        this.anofabricacao = anofabricacao;
        this.anomodelo = anomodelo;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.potencia = potencia;
        this.cilindradas = cilindradas;
        this.combustivel = combustivel;
        this.subsegmento = subsegmento;
        this.municipio = municipio;
        this.ufmunicipio = ufmunicipio;
        this.tipoveiculo = tipoveiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getNumerofaturado() {
        return numerofaturado;
    }

    public void setNumerofaturado(String numerofaturado) {
        this.numerofaturado = numerofaturado;
    }

    public String getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(String anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public String getAnomodelo() {
        return anomodelo;
    }

    public void setAnomodelo(String anomodelo) {
        this.anomodelo = anomodelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(String cilindradas) {
        this.cilindradas = cilindradas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getSubsegmento() {
        return subsegmento;
    }

    public void setSubsegmento(String subsegmento) {
        this.subsegmento = subsegmento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUfmunicipio() {
        return ufmunicipio;
    }

    public void setUfmunicipio(String ufmunicipio) {
        this.ufmunicipio = ufmunicipio;
    }

    public String getTipoveiculo() {
        return tipoveiculo;
    }

    public void setTipoveiculo(String tipoveiculo) {
        this.tipoveiculo = tipoveiculo;
    }
}
