package br.com.ifmt.dao;

import br.com.ifmt.model.Roupa;
import java.util.List;

/**
 *
 * @author Vitor Santos
 */
public interface InterfaceRoupa {

    public void inserirRoupa(Roupa roupa);

    public void excluirRoupa(Roupa roupa);

    public void atualizaRoupa(Roupa roupa);

    public List<Roupa> listaRoupa();
    public List<Roupa> buscaRoupa(String coluna);
}
