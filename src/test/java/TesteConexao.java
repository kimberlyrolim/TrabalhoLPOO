import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TesteConexao {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TesteConexao() {

        emf = Persistence.createEntityManagerFactory("pu_loja");
        em = emf.createEntityManager();
    }
    
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
}
