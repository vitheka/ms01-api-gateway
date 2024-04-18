package br.com.vitor.ms01apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

        return builder
                .routes()
                .route(p -> p.path("/get")
                .filters(f -> f
                        .addRequestHeader("hello", "world")
                        .addRequestParameter("Ciao", "Mondo")
                )
                .uri("http://httpbin.org:80"))
                .route(p -> p.path("/v1/book-service/**")
                        .uri("lb://MS01-BOOK-SERVICE"))
                .build();
    }


}
