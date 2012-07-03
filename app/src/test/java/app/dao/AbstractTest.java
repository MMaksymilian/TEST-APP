package app.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 03.07.12
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */

/**
 * Po tej klasie dziedziczą wszystkie testy.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {
}