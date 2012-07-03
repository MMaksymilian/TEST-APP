package app.dao;

import core.orm.entities.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Pierwsza wersja bardziej skomplikowana, ale dała mi dużo do myślenia
 * co jest pod spodem jak używasz AbstractTransactionalJUnit4SpringContextTests
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ConcreteExplicitTest
        extends AbstractJUnit4SpringContextTests {
    private Session session;

    @Test
    public void someMethod() {
        // TODO metoda
    }

    @Before
    public void setupSession() {
        SessionFactory sessionFactory = (SessionFactory) applicationContext.
                getBean("hibernateSessionFactory");
        session = sessionFactory.openSession();
        session.getTransaction().begin();
    }

    @After
    public void tearDownSession() {
        session.getTransaction().rollback();
        session.close();
    }
}
