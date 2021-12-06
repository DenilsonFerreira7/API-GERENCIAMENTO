package lab.ti.com.br.lab.ti.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MaquinaNotFoundException extends Exception {

   public MaquinaNotFoundException(Long patrimonio) {
      super("Não foi encontrado esse valor no banco de dados");

    }


}



