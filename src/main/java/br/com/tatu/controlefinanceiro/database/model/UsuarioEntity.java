package br.com.tatu.controlefinanceiro.database.model;

import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    @Id
    private Integer id;
    @Column(unique = true )
    private String email;
    private String senha;



    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransacaoEntity> transacoes = new ArrayList<>();


    /**
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    /**
     * @return
     */
    @Override
    public @Nullable String getPassword() {
        return senha;
    }

    /**
     * @return
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    /**
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    /**
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    /**
     * @return
     */
    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }




    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RolesEntity> roles = new HashSet<>();



}