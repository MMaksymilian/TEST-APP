package app.security;

import core.orm.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestAppUserDetails implements UserDetails {
    private User user;
    private boolean accountNonExpried = true;
    private boolean accountNonLocked = true;
    private boolean creditentialsNonExpired = true;
    private boolean enabled = true;


    public TestAppUserDetails(User user){
        this.user = user;
    }
    public TestAppUserDetails(User user, boolean accountNonExpired, boolean accountNonLocked, boolean creditentialsNonExpired,
                          boolean enabled, List<GrantedAuthority> list){
        this.user = user;
        this.accountNonExpried = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.creditentialsNonExpired = creditentialsNonExpired;
        this.enabled = enabled;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getLogin();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}