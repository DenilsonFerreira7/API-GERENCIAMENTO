package lab.ti.com.br.lab.ti.Service;
import lab.ti.com.br.lab.ti.Entities.Maquinas;
import lab.ti.com.br.lab.ti.Repository.MaquinaRepository;
import lab.ti.com.br.lab.ti.dto.response.MessageResponseDTO;
import lab.ti.com.br.lab.ti.exception.MaquinaNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
    public class MaquinaService {
    private MaquinaRepository maquinaRepository;


    public MaquinaService(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }
    public MessageResponseDTO updateMaquina(Long patrimonio, Maquinas maquinas) throws MaquinaNotFoundException {
        verifyifExists(patrimonio);
        Maquinas updateMaquina = maquinaRepository.save(maquinas);
        return createdMessageResponse(updateMaquina.getPatrimonio(), " foi atulizado no banco de dados");
    }
    public MessageResponseDTO saveMaquina(Maquinas maquinas) {
        Maquinas saveMaquina = maquinaRepository.save(maquinas);
        return createdMessageResponse(saveMaquina.getPatrimonio(), " foi inserido no banco de dados");
    }
    public List<Maquinas> listAll() {
        List<Maquinas> allMaquinas = maquinaRepository.findAllByOrderBySetorAsc();
        return allMaquinas.stream()
                .map(Maquinas::converter)
                .collect(Collectors.toList());
    }
    public List<Maquinas> consultaPorSetor(String setor) {
        return maquinaRepository.findBySetorContaining(setor);
    }
    public Optional<Maquinas> findByPat(long patrimonio) throws MaquinaNotFoundException {
        Maquinas maquinas = verifyifExists(patrimonio);
        return maquinaRepository.findById(patrimonio);
    }
    public Maquinas findByChamado(Long chamado) throws MaquinaNotFoundException {
        Maquinas maquinas = verifyifExists(chamado);
        return maquinaRepository.findByChamado(chamado);
    }
    public void delete(Long patrimonio) throws MaquinaNotFoundException {
        maquinaRepository.findById(patrimonio)
                .orElseThrow(() -> new MaquinaNotFoundException(patrimonio));
        maquinaRepository.deleteById(patrimonio);
    }
    private Maquinas verifyifExists(Long patrimonio) throws MaquinaNotFoundException {
        return maquinaRepository.findById(patrimonio)
                .orElseThrow(() -> new MaquinaNotFoundException(patrimonio));
    }
    private MessageResponseDTO createdMessageResponse(Long patrimonio, String s) {
        return MessageResponseDTO
                .builder()
                .message("Maquina do patrimonio " + patrimonio + s)
                .build();
        }
    }




















