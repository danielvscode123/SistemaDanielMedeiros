/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DhmVendas;
import bean.DhmVendasProdutos;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u1845853
 */
public class VendasProdutosDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(DhmVendasProdutos.class);
        criteria.add(Restrictions.eq("dhmIdVendasProdutos", codigo)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listProdutos(DhmVendas vendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendasProdutos.class);
        criteria.add(Restrictions.eq("dhmVendas", vendas));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
    
    public void deleteProdutos(DhmVendas vendas) {
   
        List lista = (List) listProdutos(vendas);
        //deleta  a lista acima 
        session.beginTransaction();
        for (int i = 0; i < lista.size(); i++) {
            DhmVendasProdutos vendasProdutos = (DhmVendasProdutos) lista.get(i);
            //delete(vendasProdutos);
            session.flush();
            session.clear();
            session.delete(vendasProdutos);
        }
        session.getTransaction().commit();
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendasProdutos.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public static void main(String[] args) {
        VendasProdutosDAO usuariosDAO = new VendasProdutosDAO();
        usuariosDAO.listAll();
    }
}
