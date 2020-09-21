package se.techinsight.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class ProdNotificationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private NotificationProperties notificationProperties;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        notificationProperties.getMails().forEach(System.out::println);
    }
}
