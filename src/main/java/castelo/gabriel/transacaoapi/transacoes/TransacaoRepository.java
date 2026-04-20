package castelo.gabriel.transacaoapi.transacoes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TransacaoRepository {

    List<TransacaoDTO> transacaoList = new ArrayList<>();

    public void save(TransacaoDTO dto){
        log.info("Salvando transação");
        this.transacaoList.add(dto);
    }

    public void delete(){
        log.info("Apagando todas as transações");
        this.transacaoList.clear();
    }

    public List<TransacaoDTO> get(){
        return this.transacaoList;
    }
}
