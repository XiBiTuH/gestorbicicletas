/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestorbicicletas;

import java.io.Serializable;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Pedro
 */
public class Bicicleta implements Serializable  {

    private String quadro;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    private String rodas;
    private String transmissao;
    private String travoes;
    private String espigao;
    private String guiador;
    private String descricao;
    private int dono;
    private Boolean disponibilidade;

    public Bicicleta(int dono, String quadro, String rodas, String transmissao, String travoes, String espigao, String guiador,String descricao) {

        this.dono = dono;
        this.quadro = quadro;
        this.rodas = rodas;
        this.transmissao = transmissao;
        this.travoes = travoes;
        this.espigao = espigao;
        this.guiador = guiador;
        this.descricao = descricao;
        this.disponibilidade = true;

    }

    @Override
    public String toString() {
        return "Bicicleta{" + "quadro=" + quadro + ", rodas=" + rodas + ", transmissao=" + transmissao + ", travoes=" + travoes + ", espigao=" + espigao + ", guiador=" + guiador + ", dono=" + dono + ", disponibilidade=" + disponibilidade + '}';
    }


    public int getDono() {
        return dono;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }

    public String getQuadro() {
        return quadro;
    }

    public void setQuadro(String quadro) {
        this.quadro = quadro;
    }

    public String getRodas() {
        return rodas;
    }

    public void setRodas(String rodas) {
        this.rodas = rodas;
    }


    public String getGuiador() {
        return guiador;
    }

    public void setGuiador(String guiador) {
        this.guiador = guiador;
    }

    public String getTransmissao() {
        return transmissao;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public String getTravoes() {
        return travoes;
    }

    public void setTravoes(String travoes) {
        this.travoes = travoes;
    }

    public String getEspigao() {
        return espigao;
    }

    public void setEspigao(String espigao) {
        this.espigao = espigao;
    }


    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void getDisponibilidade(String disponibilidade) {
        this.quadro = disponibilidade;
    }

}
