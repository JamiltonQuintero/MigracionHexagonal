package com.migracion.hexagonal.beanconfiguracion;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
@Slf4j
class CircuitBreakerConfiguration {

    @Bean
    public CircuitBreaker remittanceServiceCircuitBreaker(CircuitBreakerRegistry registry) {
        return registry.circuitBreaker("problema");
    }

    @Bean
    public Retry remittanceServiceRetry(RetryRegistry registry) {
        Retry retry = registry.retry("problema");
        retry.getEventPublisher()
                .onRetry(event -> log.info("Retry attempt number: " + event.getNumberOfRetryAttempts() +
                        ", Retry event: " + event.getEventType() +
                        ", Exception: " + event.getLastThrowable()));
        return retry;
    }

    @Bean
    public TimeLimiter remittanceServiceTimeLimiter(TimeLimiterRegistry registry) {
        return registry.timeLimiter("problema");
    }
}