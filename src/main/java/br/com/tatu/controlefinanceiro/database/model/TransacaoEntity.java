package br.com.tatu.controlefinanceiro.database.model;
import br.com.tatu.controlefinanceiro.typeEnum.Categoria;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@Entity
@Table(name = "transacao")
public class TransacaoEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transacao_id")
    @Id
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private double valor;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity idUsuario;


}
