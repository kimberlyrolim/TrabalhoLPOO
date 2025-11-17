package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Cliente;
import model.Vendedor;

public class VendedorDAO extends PersistenciaJPA{
    
    public List<Vendedor> listaVendedores(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Vendedor> query
                    = em.createQuery("SELECT v FROM Vendedor v", Vendedor.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
