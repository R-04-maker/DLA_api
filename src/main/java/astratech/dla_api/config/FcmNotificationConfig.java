package astratech.dla_api.config;

import astratech.dla_api.service.FcmNotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FcmNotificationConfig {
    @Bean
    public FcmNotificationService fcmNotificationService() {
        return new FcmNotificationService();
    }
}