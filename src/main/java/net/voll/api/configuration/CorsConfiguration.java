package net.voll.api.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("Get");
    }
}
