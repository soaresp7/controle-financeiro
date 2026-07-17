package br.com.tatu.controlefinanceiro.database.repository;

import br.com.tatu.controlefinanceiro.database.model.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity,Integer> {
}
