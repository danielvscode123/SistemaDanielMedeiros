/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.DhmUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author u07887987156
 */
public class UsuariosDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
session.beginTransaction();
    
    // FORÇA o ID que está no objeto (solução para seu problema)
    if (object instanceof DhmUsuarios) {
        DhmUsuarios usuario = (DhmUsuarios) object;
        // Usa merge() em vez de save() para forçar o ID
        session.merge(object);
    } else {
        session.save(object);
    }
    
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
    Criteria criteria = session.createCriteria(DhmUsuarios.class);
    // CORREÇÃO: Mudar "idusuarios" para "dhmIdUsuario"
    criteria.add(Restrictions.eq("dhmIdUsuario", codigo));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

    @Override
    public Object listAll() {
session.beginTransaction();
  Criteria criteria = session.createCriteria(DhmUsuarios.class);
  List lista = criteria.list();
  session.getTransaction().commit();
 return lista;
              }
    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.listAll();
    }
    
    
    
    

public List<DhmUsuarios> listByName(String nome) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(DhmUsuarios.class);
    criteria.add(Restrictions.ilike("dhmNome", "%" + nome + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}



    
}
