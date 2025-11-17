package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Venda;

public class VendaDAO extends PersistenciaJPA{
    public List<Venda> listaVendas(){
    EntityManager em = getEntityManager();
        try {
            TypedQuery<Venda> query
                    = em.createQuery("SELECT v FROM Venda v", Venda.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
