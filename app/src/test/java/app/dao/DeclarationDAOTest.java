package app.dao;

import core.orm.dao.DeclarationDAO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 03.07.12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class DeclarationDAOTest extends AbstractTest {

    @Autowired
    DeclarationDAO declarationDAO;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void someTest() {
        String[] array = new String[2];
        exception.expect(IndexOutOfBoundsException.class);
        for(int index = 0 ; index < 3 ; index++) {
            array[index] = "test";
        }
    }

}
