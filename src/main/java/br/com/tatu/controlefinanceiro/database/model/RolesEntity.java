package br.com.tatu.controlefinanceiro.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class RolesEntity implements GrantedAuthority {

    @Id
    @Column(name = "role_id")
    private Integer Id;

    private String nome;



    @Override
    public @Nullable String getAuthority() {
        return nome;
    }
}
