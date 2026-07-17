package br.com.tatu.controlefinanceiro.Dto;

import br.com.tatu.controlefinanceiro.typeEnum.Categoria;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransacaoDto {
    private String descricao;
    private Categoria categoria;
    private double valor;

}
