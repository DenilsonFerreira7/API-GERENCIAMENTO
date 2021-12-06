package lab.ti.com.br.lab.ti.Repository;
import lab.ti.com.br.lab.ti.Entities.Maquinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaquinaRepository extends JpaRepository <Maquinas,Long> {

    List<Maquinas> findAllByOrderBySetorAsc();
    Maquinas findByChamado (Long chamado);
    List<Maquinas> findBySetorContaining (String setor);


}
