package lab.ti.com.br.lab.ti.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lab.ti.com.br.lab.ti.Entities.Maquinas;
import lab.ti.com.br.lab.ti.Service.MaquinaService;
import lab.ti.com.br.lab.ti.dto.response.MessageResponseDTO;
import lab.ti.com.br.lab.ti.exception.MaquinaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping(value="/LAB")
    @Api(value="API REST")
    public class ControleDeMaquinas {

        @Autowired
        private MaquinaService maquinaService;

        public ControleDeMaquinas(MaquinaService maquinaService) {
            this.maquinaService = maquinaService;

        }

        @ApiOperation(value = "Registrar Maquinas")
        @PostMapping(value = "{Registrar maquina parada}")
        public MessageResponseDTO saveMaquinas(@RequestBody Maquinas maquinas) {
            return maquinaService.saveMaquina(maquinas);
        }

        @GetMapping("/{Lista de Maquinas}")
        @ApiOperation(value = "Lista completa de maquinas paradas")
        public List<Maquinas> listAll() {
            return maquinaService.listAll();
        }
        @GetMapping("/{Maquinas por setor}")
        @ApiOperation(value = "Pesquisa maquinas por setor")
        public List<Maquinas> consultaPorSetor(String setor) {
            return maquinaService.consultaPorSetor(setor);
        }
        @GetMapping("/{Consultar pelo Patrimonio}")
        @ApiOperation(value = "Encontrar pelo patrimonio")
        public Optional<Maquinas> findByPat(@RequestParam long patrimonio) throws MaquinaNotFoundException {
            return maquinaService.findByPat(patrimonio);
        }
        @GetMapping("/{Consultar pelo chamado}")
        @ApiOperation(value = "Encontrar pelo chamado")
        public Maquinas findByChamado(@RequestParam Long chamado) throws MaquinaNotFoundException {
            return maquinaService.findByChamado(chamado);
        }
        @DeleteMapping("/{DELETAR}")
        @ApiOperation(value = "Deletar registo do banco de dados")
        public void delete ( Long patrimonio) throws MaquinaNotFoundException {
            maquinaService.delete(patrimonio);
        }
        @PutMapping("/{Atualizar dado existente}")
        @ApiOperation(value = "Atualizar registro no Banco de dados")
        public MessageResponseDTO updateByPat ( Long pat_nti ,@RequestBody Maquinas maquinas) throws MaquinaNotFoundException {
           return maquinaService.updateMaquina(pat_nti,maquinas);
        }

    }

