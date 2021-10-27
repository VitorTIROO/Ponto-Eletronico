package br.com.ifmt.dao;

import br.com.ifmt.model.Usuario;

/**
 *
 * @author Vitor Santos
 */
public interface InterfaceUsuario {

    public Usuario login(String login, String senha);

}
