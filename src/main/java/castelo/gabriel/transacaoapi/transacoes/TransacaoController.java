package castelo.gabriel.transacaoapi.transacoes;

import castelo.gabriel.transacaoapi.docs.TransacaoControllerDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
@Slf4j
public class TransacaoController implements TransacaoControllerDoc {

    private final TransacaoService transacaoService;
    private final TransacaoRepository transacaoRepository;

    public TransacaoController(TransacaoService transacaoService, TransacaoRepository transacaoRepository) {
        this.transacaoService = transacaoService;
        this.transacaoRepository = transacaoRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody TransacaoDTO dto) {
        try {
            transacaoService.validarTransacao(dto);
            transacaoRepository.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException exception) {
            log.error("Erro em uma ou mais validações");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e) {
            log.error("Erro na requisição");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(){
        transacaoRepository.delete();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
