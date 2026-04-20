package castelo.gabriel.transacaoapi.estatisticas;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class EstatisticaDTO {
    private final long count;
    private final BigDecimal sum;
    private final BigDecimal min;
    private final BigDecimal max;
    private final BigDecimal avg;


    public EstatisticaDTO(long count, BigDecimal sum, BigDecimal min, BigDecimal max, BigDecimal avg) {
        this.count = count;
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.avg = avg;
    }
}
