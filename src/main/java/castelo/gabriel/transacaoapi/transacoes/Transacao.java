package castelo.gabriel.transacaoapi.transacoes;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @NotNull(message = "Valor da transação é obrigatório")
    @Positive(message = "Valor da transação deve ser igual ou maior que zero")
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
