
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DhmVendas;
import bean.DhmVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07887987156
 */
public class VendasDAO extends AbstractDAO {

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.delete(object);
        session.getTransaction().commit();
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendas.class);
        criteria.add(Restrictions.eq("dhmIdVendas", codigo)); // 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listTotal(double valor) {
          session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendas.class);
        criteria.add(Restrictions.ge("dhmPreco", valor ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCliente(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendas.class);
        criteria.add(Restrictions.eq("dhmNivel", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listTotalCliente(int codigo, int valor) {
    session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendas.class);
        criteria.add(Restrictions.like("dhmNome", codigo));
        criteria.add(Restrictions.ge("dhmPreco", valor ));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        VendasDAO usuariosDAO = new VendasDAO();
        usuariosDAO.listAll();
    }

}
