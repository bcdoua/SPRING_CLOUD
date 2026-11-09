package com.douaa.gatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRouteConfig {

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p
                        .path("/api/couleurs/**")
                        .uri("lb://COULEUR"))
                .route(p -> p
                        .path("/api/accessoires/**")
                        .filters(f -> f.circuitBreaker(config -> config
                                .setName("accessoireCircuitBreaker")
                                .setFallbackUri("forward:/contactAdmin")))
                        .uri("lb://ACCESSOIRE"))
                .build();
    }
}