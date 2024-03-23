package DBarbosa.infraestrutura.springdoc;

import org.codehaus.plexus.component.annotations.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

}
