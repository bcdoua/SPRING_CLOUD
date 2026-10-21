package com.douaa.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);

    /*@Bean
    public RouteLocator myRouteConfig(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/couleurs/**")
                        .uri("lb://COULEUR"))
                .route(p -> p
                        .path("/api/accessoires/**")
                        .uri("lb://ACCESSOIRE"))
                .build();
    }*/
}
}
