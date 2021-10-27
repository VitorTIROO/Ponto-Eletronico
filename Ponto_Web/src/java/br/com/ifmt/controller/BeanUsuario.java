package br.com.ifmt.controller;

import br.com.ifmt.dao.InterfaceUsuario;
import br.com.ifmt.dao.UsuarioDAO;
import br.com.ifmt.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vitor Santos
 */
@ManagedBean(name = "ctrlUsuario")
@SessionScoped
public class BeanUsuario {

    public BeanUsuario() {
    }

    public String btLogar() {

        InterfaceUsuario USUARIO = new UsuarioDAO();
        usuario = new Usuario();

        if (USUARIO.login(getLogin(), getSenha()) == null) {
            mensagem(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Acesso negado!", "Login ou senha incorreto!"));
        } else {
            usuario = USUARIO.login(getLogin(), getSenha());

            if (usuario.getTipo().equalsIgnoreCase("Consultor")) {
                return "consultor";
            } else if (usuario.getTipo().equalsIgnoreCase("Gerente")) {
                return "gerente";
            }
        }
        return "index";
    }

    public String btLogout() {
        return "index";
    }

    public void mensagem(FacesMessage fc) {
        FacesContext.getCurrentInstance().addMessage(null, fc);
    }//mensagem

    private Usuario usuario;
    private String senha;
    private String login;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
