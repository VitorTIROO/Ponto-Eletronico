package br.com.ifmt.dao;

import br.com.ifmt.model.Roupa;
import br.com.ifmt.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * @author Vitor Santos
 */
public class RoupaDAO implements InterfaceRoupa {

    @Override
    public void inserirRoupa(Roupa roupa) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(roupa);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    @Override
    public void excluirRoupa(Roupa roupa) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.delete(roupa);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public void atualizaRoupa(Roupa roupa) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(roupa);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
    }

    @Override
    public List<Roupa> listaRoupa() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List lista = null;
        try {
            lista = session.createQuery("From Roupa").list();
            //selecionar todos os registros da Classe Contato
            tx.commit();

        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        }
        return lista;
    }

    @Override
    public List<Roupa> buscaRoupa(String coluna) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();

        try {
            //adiciona criterios de busca na classe mapeada usuario e retorna em formato de lista(List)
            return s.createCriteria(Roupa.class).add(Restrictions.like(coluna,"")).list();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
    }

}//class
