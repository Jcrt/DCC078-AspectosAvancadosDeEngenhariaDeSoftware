/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Julio R. Trindade
 */
public class Notificacoes {
    private String numeroProcesso;
    private String mensagem;
    private Date dataNotificacao;
    
    public Notificacoes(String numeroProc, String msg, Date dtNot){
        this.dataNotificacao = dtNot;
        this.mensagem = msg;
        this.numeroProcesso = numeroProc;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }
}
