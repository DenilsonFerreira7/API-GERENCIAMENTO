package lab.ti.com.br.lab.ti.Swagger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;


@Configuration
@EnableAutoConfiguration
@EnableSwagger2
public class SwaggerConfiguration {

        @Bean
        public Docket apiAdmin() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("lab.ti.com.br.lab.ti"))
                    .paths(PathSelectors.ant("/**"))
                    .build()
                    .apiInfo(apiInfo())
                    .globalOperationParameters(
                            Collections.singletonList(
                                    new ParameterBuilder()
                                            .name("Authorization")
                                            .description("Header para Token JWT")
                                            .modelRef(new ModelRef("string"))
                                            .parameterType("header")
                                            .required(false)
                                            .build()));
        }

        @Bean
        public ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("CONTROLE DE MAQUINAS ")
                    .description("Registro de maquinas que estão paradas no setor com laudo.")
                    .version("1.0")
                    .license("Apache License Version 2.0")
                    .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                    .contact(new Contact("Denilson Ferreira", "https://www.linkedin.com/in/denilson-ferreira-dos-santos-2a994b215/", "denilsonfsantos7@gmail.com"))
                    .build();}}
