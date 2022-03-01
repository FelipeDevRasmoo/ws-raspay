package com.rasmoo.client.raspay.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String CUSTOMER = "Cliente";
    public static final String ORDER = "Pedido";
    public static final String PAYMENT = "Pagamento";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).groupName("v1").select()
                .apis(RequestHandlerSelectors.basePackage("com.rasmoo.client.raspay.controller"))
                .paths(PathSelectors.any()).build().apiInfo(this.apiInfo())
                .tags(this.customer(),this.order(),this.payment());
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        return apiInfoBuilder.title("RasPay")
                .description("FAKE API para credenciamento de transações financeiras")
                .version("1.0.0")
                .license("Rasmoo cursos de tecnologia")
                .build();
    }

    private Tag customer(){
        return new Tag(CUSTOMER,"Ao receber os dados do Cliente, o sistema deve verificar se já existe na base " +
                "um cliente com o mesmo e-mail e telefone fornecidos. Caso positivo, o mesmo será atualizado com as novas " +
                "informações enviadas. Caso não exista, o mesmo será criada. Ao criar ou atualizar o cadastro, a API retorna o 'customer_id' " +
                "desse cliente, que será utilizado nas próximas etapas de pedido e pagamento.");
    }

    private Tag order(){
        return new Tag(ORDER,"Para enviar os dados do produto e do cliente, é preciso enviar o 'customer_id' obtido na última chamada. " +
                "A API irá retornar o 'order_id' que será utilizado na etapa de pagamento. A única opção transação liberada é por meio de uma cartão de " +
                "crédito.");
    }

    private Tag payment(){
        return new Tag(PAYMENT,"Para a última etapa, é necessário informar o 'customer_id', o 'order_id' e o as informações do cartão de crédito. " +
                "Um mesmo cartão de crédito não poderá ser usado por clientes diferentes e, além disso, um mesmo cliente não poderá fazer dois pagamentos fora " +
                "do período de renovação, mesmo que com um cartão de crédito novo.");
    }
}
