package castelo.gabriel.transacaoapi.docs;

import castelo.gabriel.transacaoapi.transacoes.TransacaoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transações",
description = "Endpoints responsaveis por criar e adicionar transações a uma lista, assim como limpa-la")
public interface TransacaoControllerDoc {

    @Operation(summary = "Cria Transação",
            description = "Recebe uma transação valida e adiciona em uma lista")
    @ApiResponse(
            responseCode = "201",
            description = "Transação concluida com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Ero na validação capturado"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro na requisição"
    )
    public ResponseEntity<Void> create(@RequestBody TransacaoDTO dto);

    @Operation(summary = "Deleta todas as Transações",
            description = "Deleta todas as transações")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de transações limpa com sucesso"
    )
    public ResponseEntity<Void> delete();
}
