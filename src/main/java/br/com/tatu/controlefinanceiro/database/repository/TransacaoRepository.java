package br.com.tatu.controlefinanceiro.database.repository;

import br.com.tatu.controlefinanceiro.database.model.TransacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository extends JpaRepository<TransacaoEntity,Integer> {

    void deleteById(Integer id);
    Optional<TransacaoEntity> findById(Integer id);





}
