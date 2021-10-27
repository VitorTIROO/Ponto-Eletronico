package br.com.ifmt.dao;

import br.com.ifmt.model.Usuario;
import br.com.ifmt.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Vitor Santos
 */
public class UsuarioDAO implements InterfaceUsuario {

    @Override
    public Usuario login(String login, String senha) {

        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();
        Usuario usuario;
        try {

            Query query = s.createQuery("from Usuario where login = :login and senha = :senha");
            query.setString("login", login);
            query.setString("senha", senha);

            usuario = (Usuario) query.uniqueResult();
            tx.commit();
            return usuario;

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }
}//class
