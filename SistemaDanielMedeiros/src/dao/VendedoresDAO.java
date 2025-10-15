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

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(DhmVendedor.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
}