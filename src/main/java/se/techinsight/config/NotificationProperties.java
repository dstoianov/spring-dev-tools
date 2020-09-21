package se.techinsight.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "prod")
public class NotificationProperties {
    private List<String> mails;
    private boolean notification;
}
