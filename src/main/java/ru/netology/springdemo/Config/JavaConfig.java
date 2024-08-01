package ru.netology.springdemo.Config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springdemo.Model.DevProfile;
import ru.netology.springdemo.Model.ProductionProfile;
import ru.netology.springdemo.Model.SystemProfile;

@Configuration
public class JavaConfig {
    @ConditionalOnProperty(
            prefix = "netology",
            name = "profile.dev",
            havingValue = "true",
            matchIfMissing = true)
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(
            prefix = "netology",
            name = "profile.dev",
            havingValue = "false")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
