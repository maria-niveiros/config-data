package com.example.msgateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder) {
        return builder.routes()
        .route("ms-user", r->r.path("/user/**").uri("lb://ms-user"))
        .route("card-service", r->r.path("/accounts/{id}/cards/**").uri("lb://card-service"))
        .route("ms-account", r->r.path("/accounts/**").uri("lb://ms-account"))
        .build();
    }
}
