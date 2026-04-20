package castelo.gabriel.transacaoapi.estatisticas;

import castelo.gabriel.transacaoapi.docs.EstatisticaControllerDoc;
import castelo.gabriel.transacaoapi.transacoes.TransacaoDTO;
import castelo.gabriel.transacaoapi.transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/estatisticas")
@Slf4j
public class EstatisticaController implements EstatisticaControllerDoc {

    private final EstatisticaProperties estatisticaProperties;

    private final TransacaoRepository transacaoRepository;

    public EstatisticaController(EstatisticaProperties estatisticaProperties, TransacaoRepository transacaoRepository) {
        this.estatisticaProperties = estatisticaProperties;
        this.transacaoRepository = transacaoRepository;
    }

    @GetMapping
    public ResponseEntity<EstatisticaDTO> gerarEstatisticas(){
        log.info(("Gerando estatisticas dos ultimos " + estatisticaProperties.segundos() + " segundos"));
        OffsetDateTime timeToFilter = OffsetDateTime.now().minusSeconds(estatisticaProperties.segundos());
        List<TransacaoDTO> list = transacaoRepository.get().stream()
                .filter(t -> t.getDataHora().isAfter(timeToFilter) || t.getDataHora().isEqual(timeToFilter))
                .toList();

        List<BigDecimal> values = list.stream().map(TransacaoDTO::getValor).toList();

        long count = list.size();

        BigDecimal sum = values.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal avg = (count != 0) ? sum.divide(BigDecimal.valueOf(count), RoundingMode.UNNECESSARY) : BigDecimal.ZERO;

        BigDecimal min = values.stream().min(BigDecimal::compareTo).orElse(BigDecimal.ZERO);
        BigDecimal max = values.stream().max(BigDecimal::compareTo).orElse(BigDecimal.ZERO);

        EstatisticaDTO dto = new EstatisticaDTO(count, sum, avg, min, max);

        return ResponseEntity.ok(dto);
    }
}
