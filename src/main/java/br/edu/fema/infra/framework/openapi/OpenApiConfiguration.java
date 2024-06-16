package br.edu.fema.infra.framework.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Cooperativa Fema", version = "1.0.0"))
public class OpenApiConfiguration {
}
