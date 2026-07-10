package br.com.tatu.controlefinanceiro.database.model;
import br.com.tatu.controlefinanceiro.typeEnum.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class transacao {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    @Id
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private double valor;




}
