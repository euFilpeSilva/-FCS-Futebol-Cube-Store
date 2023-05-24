package br.com.loja.fcs.config.security;

import br.com.loja.fcs.domain.entity.Role;
import br.com.loja.fcs.domain.entity.Usuario;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Set<String> roles;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal( Usuario user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = user.getRoles().stream().map(Role::getName).collect(Collectors.toSet());

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        // ROLE_ADMIN , ROLE_USER ADMIN, USER ....
        authorities = user.getRoles().stream().map(role -> {
            return new SimpleGrantedAuthority("ROLE_".concat(role.getName()));
        }).collect(Collectors.toList());

        this.authorities = authorities;
    }

    public UserPrincipal() {

    }

    public static UserPrincipal create(Usuario user) {
        return new UserPrincipal(user);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setRole(Role role) {
    }
}
