package com.insurance.infrastructure.api_gateway.GatewayConfig;

import com.insurance.infrastructure.api_gateway.filter.JwtFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {

    private final JwtFilter filter;

    public RoutesConfig(JwtFilter filter) {
        this.filter = filter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/auth/**")
                        .uri("lb://auth-service"))
                .route("user_command", r -> r.path("/api/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://command"))
                .route("user_query", r -> r.path("/api/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://query"))
                .build();
    }
}
