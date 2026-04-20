package castelo.gabriel.transacaoapi.docs;

import castelo.gabriel.transacaoapi.estatisticas.EstatisticaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Estatísticas",
description = "Endpoint para gerar estatísticas")
public interface EstatisticaControllerDoc {

    @Operation(summary = "Gera Estatisticas",
    description = "Gera estatísticas das transações dos últimos n segundos, sendo n configurável no application.yml")
    @ApiResponse(
            responseCode = "200",
            description = "Estatística gerada com sucesso"
    )
    public ResponseEntity<EstatisticaDTO> gerarEstatisticas();

}
