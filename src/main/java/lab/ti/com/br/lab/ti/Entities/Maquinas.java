package lab.ti.com.br.lab.ti.Entities;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Maquinas {

    @Id
    private long patrimonio;

    @Column
    private long chamado;

    @Column
    private String marca;

    @Column
    private String ultimo_laudo;

    @Column
    private String setor;

    @Temporal(TemporalType.DATE)
    private Date data_de_entrada;

    public static Maquinas converter(Maquinas maquinas) {
        return maquinas;
    }

}
