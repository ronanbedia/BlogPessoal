package com.generation.blogPessoal.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.blogPessoal.models.UsuarioModel.Usuario;

public class UserDetailsImplement implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String email;
    private String password;
    private List<GrantedAuthority> autorizacoes;

    public UserDetailsImplement(Usuario user) {
        this.email = user.getEmail();
        this.password = user.getSenha();
    }

    public UserDetailsImplement() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return autorizacoes;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

}