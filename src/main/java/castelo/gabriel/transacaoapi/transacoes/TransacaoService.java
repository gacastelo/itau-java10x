package castelo.gabriel.transacaoapi.transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneId;
@Slf4j
@Service
public class TransacaoService {
    public void validarTransacao(TransacaoDTO dto){
        log.info("Validando transação");
        if (dto.getDataHora() == null){
            throw new IllegalArgumentException("Erro: A data não pode ser nula");
        }

        if (dto.getValor() == null){
            throw new IllegalArgumentException("Erro: O valor não pode ser nulo");
        }

        if (dto.getValor().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Erro: Valor da transação não pode ser menor ou igual a zero");
        }
        if (dto.getDataHora().isAfter(OffsetDateTime.now(ZoneId.of("America/Sao_Paulo")))){
            throw new IllegalArgumentException("Erro: A Transação não pode ser feita no futuro");
        }
    }
}
