package app.dao;

import core.orm.dao.AppUserDAO;
import core.orm.entities.AppUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 03.07.12
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOTest extends AbstractTest {
    @Autowired
    AppUserDAO appUserDAO;

    @Test
    public void getUser() {
        String login = "Rambo";
        AppUser user = appUserDAO.getUserByLogin(login);
        if (user != null) {
            assertEquals("Niezgodny login", login , user.getLogin());
        }
    }

//    @ActiveProfiles - SPRING 3.1 bardzo ciekawa adnotacja!
    @Test(timeout = 500)
    public void checkUsers() {
        for (AppUser user : appUserDAO.getAllUsers()) {
            assertNotNull("Użytkownik bez login- u", user.getLogin());
            assertTrue("Hasło musi być dłuższe niż 2, użytkownik: " + user.getLogin(), user.getPassword().length() > 2);
        }
    }
}
