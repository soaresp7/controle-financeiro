package br.com.tatu.controlefinanceiro.service;


import br.com.tatu.controlefinanceiro.Dto.TransacaoDto;
import br.com.tatu.controlefinanceiro.database.model.TransacaoEntity;
import br.com.tatu.controlefinanceiro.database.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public void save(TransacaoDto transacao){
       transacaoRepository.save( TransacaoEntity.builder()
                .valor(transacao.getValor())
                .descricao(transacao.getDescricao())
                .categoria(transacao.getCategoria())
                .build()
       );
    }

    public void deleteById(Integer id){
        transacaoRepository.deleteById(id);
    }


    public List<TransacaoEntity> findAll(){
        return transacaoRepository.findAll();
    }


    public TransacaoEntity updatePontoByFields(Integer id, Map<String, Object> fields) {
        Optional<TransacaoEntity> existingPonto = transacaoRepository.findById(id);

        if (existingPonto.isPresent()) {
            TransacaoEntity entityToUpdate = existingPonto.get();
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(TransacaoEntity.class, key);
                if (field != null) {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, entityToUpdate, value);
                }
            });

            TransacaoEntity updatedEntity = transacaoRepository.save(entityToUpdate);

            return updatedEntity;
        }
        return null;
    }












}
