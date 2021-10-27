package br.com.ifmt.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vitor Santos
 */
@ManagedBean(name = "ctrl")
@SessionScoped
public class Bean {

    public Bean() {
    }
    
    public String abrirMenu() {
        return "menu";
    }
    
    public String abrirIndex() {
        return "index";
    }

    public void mensagem(FacesMessage fc) {
        FacesContext.getCurrentInstance().addMessage(null, fc);
    }//mensagem
    
}
