package castelo.gabriel.transacaoapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                    new Info()
                        .title("Api desafio técnico ITAU + Java10x")
                        .description("Api de desafio técnico do ITAU + Java10x")
                        .version("1.0.0")
                );
    }


}
