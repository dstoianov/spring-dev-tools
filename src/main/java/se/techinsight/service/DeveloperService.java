package se.techinsight.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("DEV")
public class DeveloperService {

    @Scheduled(cron = "1/1 * * * * ?")
    public void doWork() {
        log.info("Developers......");
    }
}
