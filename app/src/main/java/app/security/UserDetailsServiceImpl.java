package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import core.orm.dao.UserDAO;
import core.orm.entities.User;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        List<GrantedAuthorityImpl> grantedAuth = new LinkedList<GrantedAuthorityImpl>();
        grantedAuth.add(new GrantedAuthorityImpl("ROLE_USER"));
        User databaseUser = userDAO.getUserByLogin(username);
        if (databaseUser != null) {
            return new TestAppUserDetails(databaseUser);
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    @Autowired
    private UserDAO userDAO;
}
