package se.techinsight.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(NotificationProperties.class)
public class Conf {

    @Bean
    @Profile("PROD")
    @ConditionalOnMissingBean(name = "prodNotificationListener")
    @ConditionalOnProperty(name = "prod.notification", matchIfMissing = true, havingValue = "true")
    //https://youtu.be/8xa0RWMwAOE?t=9947
    public ProdNotificationListener listener() {
        return new ProdNotificationListener();
    }
}
