package app.security;

import core.orm.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestAppUserDetails implements UserDetails {
    private AppUser appUser;
    private boolean accountNonExpried = true;
    private boolean accountNonLocked = true;
    private boolean creditentialsNonExpired = true;
    private boolean enabled = true;


    public TestAppUserDetails(AppUser appUser){
        this.appUser = appUser;
    }
    public TestAppUserDetails(AppUser appUser, boolean accountNonExpired, boolean accountNonLocked, boolean creditentialsNonExpired,
                          boolean enabled, List<GrantedAuthority> list){
        this.appUser = appUser;
        this.accountNonExpried = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.creditentialsNonExpired = creditentialsNonExpired;
        this.enabled = enabled;
    }

    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<GrantedAuthority>();
    }

    public String getPassword() {
        return appUser.getPassword();
    }

    public String getUsername() {
        return appUser.getLogin();
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

    public AppUser getAppUser() {
        return appUser;
    }
}