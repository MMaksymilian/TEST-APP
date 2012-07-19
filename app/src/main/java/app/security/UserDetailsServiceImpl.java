package app.security;

import core.orm.dao.AppUserDAO;
import core.orm.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * AppUser: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserDAO appUserDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        AppUser databaseAppUser = appUserDAO.getUserByLogin(username);
        if (databaseAppUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new TestAppUserDetails(databaseAppUser);
    }
}
