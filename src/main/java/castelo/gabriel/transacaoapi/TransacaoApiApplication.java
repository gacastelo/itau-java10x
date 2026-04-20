package castelo.gabriel.transacaoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class TransacaoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransacaoApiApplication.class, args);
    }

}
