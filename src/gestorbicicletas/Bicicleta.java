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
public class Bicicleta implements Serializable {

    private String quadro;
    private static int counter = 1;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    private int id;
    private String rodas;
    private String transmissao;
    private String travoes;
    private String espigao;
    private String guiador;
    private String descricao;
    private int dono;
    private Boolean disponibilidade;

    public Bicicleta(int dono, String quadro, String rodas, String transmissao, String travoes, String espigao, String guiador, String descricao) {

        this.dono = dono;
        this.quadro = quadro;
        this.rodas = rodas;
        this.transmissao = transmissao;
        this.travoes = travoes;
        this.espigao = espigao;
        this.guiador = guiador;
        this.descricao = descricao;
        this.disponibilidade = true;
        this.id = counter;
        counter++;

    }

    @Override
    public String toString() {
        if (this.disponibilidade == true) {
            return " Id = " + id + " \n Quadro=" + quadro + "\n Rodas=" + rodas + "\n transmissao = " + transmissao + "\n Travoes = " + travoes + "\n Espigao= " + espigao + "\n Guiador= " + guiador + "\n Dono=" + dono + "\n Disponibilidade = Disponível" + "\n Descricao : " + descricao + "\n\n";

        } else {
            return " Id = " + id + " \n Quadro=" + quadro + "\n Rodas=" + rodas + "\n transmissao = " + transmissao + "\n Travoes = " + travoes + "\n Espigao= " + espigao + "\n Guiador= " + guiador + "\n Dono=" + dono + "\n Disponibilidade = Reservado" + "\n Descricao : " + descricao + "\n\n";

        }
    }

    public int getDono() {
        return dono;
    }

    public int getId() {
        return id;
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
