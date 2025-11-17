package model.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.Produto;

public class ProdutoDAO extends PersistenciaJPA {

    public List<Produto> listaProduto() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query
                    = em.createQuery("SELECT p FROM Produto p", Produto.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<Produto> buscarPorNome(String prodNome) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.prodNome = :produto", Produto.class);
            query.setParameter("produto", prodNome);
            return query.getResultList().stream().findFirst();
        } finally {
            em.close();
        }
    }
}
