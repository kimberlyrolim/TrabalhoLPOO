package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.Produto;

public class ClienteDAO extends PersistenciaJPA{
    public List<Cliente> listaClientes(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Cliente> query
                    = em.createQuery("SELECT v FROM Cliente v", Cliente.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
