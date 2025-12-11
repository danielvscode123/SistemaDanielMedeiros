package dao;

import bean.DhmVendedor;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class VendedoresDAO extends AbstractDAO {

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
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        criteria.add(Restrictions.eq("dhmIdVendedor", codigo));
        Object vendedor = criteria.uniqueResult();
        session.getTransaction().commit();
        return vendedor;
    }

    public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        criteria.add(Restrictions.like("dhmNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listSalario(double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        criteria.add(Restrictions.ge("dhmSalario", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listNomeSalario(String nome, double valor) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        criteria.add(Restrictions.like("dhmNome", "%" + nome + "%"));
        criteria.add(Restrictions.ge("dhmSalario", valor));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}
